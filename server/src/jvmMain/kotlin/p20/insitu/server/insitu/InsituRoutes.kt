package p20.insitu.server.insitu

import com.auth0.jwt.JWT
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.http.auth.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.*
import p20.insitu.com.authApi.AuthApiSettings
import p20.insitu.com.authApi.TokenInfo
import p20.insitu.com.authApi.UserInfo
import p20.insitu.com.authApi.authRedirectUri
import p20.insitu.com.insituApi.InsituApiRoutes
import p20.insitu.com.insituApi.InsituApiSettings
import p20.insitu.server.HttpClient
import p20.insitu.server.classLabelNames
import p20.insitu.server.detectObjects
import p20.insitu.server.topK
import p20.insitu.util.adminPassword
import p20.insitu.util.adminUser
import java.util.*

fun Route.start() {
    get(InsituApiRoutes.START) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            call.respondRedirect(InsituApiRoutes.HELLO)
        } ?: run {
            call.respondHtml {
                body {
                    div {
                        p {
                            text("Members only")
                        }
                        p {
                            a("${InsituApiSettings.SERVER_URL}${InsituApiRoutes.LOGIN}") {
                                target = ATarget.self
                                +"Login"
                            }
                        }
                    }
                }
            }
        }
    }
}

fun Route.login() {
    get(InsituApiRoutes.LOGIN) {

    }
}

fun Route.successfulLogin() {
    get(InsituApiRoutes.SUCCESSFUL_LOGIN) {
        call.authentication.principal<OAuthAccessTokenResponse.OAuth2>()?.let { principal ->
            call.sessions.set(
                AuthApiSettings.USER_SESSION_COOKIE,
                TokenInfo(
                    accessToken = principal.accessToken,
                    tokenType = principal.tokenType,
                    expiresIn = JWT.decode(principal.accessToken).getClaim("exp").asLong(),
                    refreshToken = principal.refreshToken,
                    refreshExpiresIn = JWT.decode(principal.refreshToken).getClaim("exp").asLong(),
                    scope = JWT.decode(principal.accessToken).getClaim("scope").asString()
                )
            )
            call.respondRedirect(InsituApiRoutes.HELLO)
        } ?: run {
            call.respondRedirect(InsituApiRoutes.START)
        }
    }
}

fun Route.hello(){
    get(InsituApiRoutes.HELLO) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            call.respondHtml {
                body {
                    div {
                        p {
                            text("Token issued at: ${Date(JWT.decode(tokenInfo.accessToken).getClaim("iat").asLong() * 1000)}")
                        }
                        p {
                            text("Token expires at: ${Date(tokenInfo.expiresIn * 1000)}")
                        }
                        p {
                            text("Username: ${JWT.decode(tokenInfo.accessToken).getClaim("preferred_username").asString()}")
                        }
                        p {
                            text("Given name: ${JWT.decode(tokenInfo.accessToken).getClaim("given_name").asString()}")
                        }
                        p {
                            text("Family Name: ${JWT.decode(tokenInfo.accessToken).getClaim("family_name").asString()}")
                        }
                        p {
                            text("E-Mail: ${JWT.decode(tokenInfo.accessToken).getClaim("email").asString()}")
                        }
                        p {
                            text("Access Token: ${tokenInfo.accessToken}")
                        }
                        p {
                            text("Refresh Token: ${tokenInfo.refreshToken}")
                        }
                        tokenInfo.refreshExpiresIn?.let {
                            p {
                                text(
                                    "Refresh Token expires at: ${
                                        Date(it * 1000)
                                    }"
                                )
                            }
                        }
                        p {
                            text("request uri: ${call.request.uri}")
                        }
                        p {
                            a("${InsituApiSettings.SERVER_URL}${InsituApiRoutes.FORM_DETECT_OBJECTS_IN_IMAGE}") {
                                target = ATarget.self
                                +"Object Detection"
                            }
                        }
                        p {
                            a("${AuthApiSettings.AUTH_URL}/auth/realms/INSITU/protocol/openid-connect/logout?redirect_uri=${InsituApiSettings.SERVER_URL}${InsituApiRoutes.LOGIN}") {
                                target = ATarget.self
                                +"Logout"
                            }
                        }

                    }
                }
            }
        } ?: run {
            call.respondRedirect(InsituApiRoutes.LOGIN)
        }
    }
}

fun Route.formDetectObjectsInImage() {
    get(InsituApiRoutes.FORM_DETECT_OBJECTS_IN_IMAGE) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            call.respondHtml {
                body {
                    form(
                        action = InsituApiRoutes.DETECT_OBJECTS_IN_IMAGE,
                        encType = FormEncType.multipartFormData,
                        method = FormMethod.post
                    ) {
                        p {
                            +"Your image: "
                            fileInput(name = "image")
                        }
                        p {
                            +"TopK: "
                            numberInput(name = topK)
                        }
                        p {
                            +"Classes to detect: "
                            textInput(name = classLabelNames)
                        }
                        p {
                            submitInput() { value = "Detect objects" }
                        }
                    }
                }
            }
        } ?: run {
            call.respondRedirect(InsituApiRoutes.LOGIN)
        }
    }
}

fun Route.test() {
    get(InsituApiRoutes.TEST) {
        val authHeader = call.request.parseAuthorizationHeader()
        val userInfo: UserInfo? = if (!(authHeader == null
                    || authHeader !is HttpAuthHeader.Single
                    || authHeader.authScheme != "Bearer")) {
            HttpClient.verifyToken(authHeader.blob)
        } else  null

        if (userInfo != null) {
            call.respondText { "Hell0 ${userInfo.firstName}!" }
        } else {
            call.response.headers.append("WWW-Authenticate", "Bearer realm=\"INSITU\"")
            call.response.status(HttpStatusCode.Unauthorized)
            call.respond("No valid token!")
        }
    }
}

fun Route.detectObjectsInImage() {
    post(InsituApiRoutes.DETECT_OBJECTS_IN_IMAGE) {
        (call.sessions.get(AuthApiSettings.USER_SESSION_COOKIE) as? TokenInfo)?.let { tokenInfo ->
            val multipartData = call.receiveMultipart()
            var fileName = ""
            var fileBytes = byteArrayOf()
            var topKCount = 20
            val classLabels = mutableListOf<String>()
            multipartData.forEachPart { part ->
                when (part) {
                    is PartData.FileItem -> {
                        fileName = part.originalFileName as String
                        fileBytes = part.streamProvider().readBytes()
                    }
                    is PartData.FormItem -> {
                        when (part.name) {
                            topK -> topKCount =
                                if (part.value.isNotBlank()) part.value.toInt() else 20
                            classLabelNames -> part.value.split(",").forEach {
                                if (it.isNotBlank()) {
                                    classLabels += it.trim()
                                }
                            }
                        }
                    }
                    is PartData.BinaryItem -> TODO()
                }
            }

            val newFileName = detectObjects(fileName, fileBytes, topKCount, classLabels)

            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName,
                    newFileName
                )
                    .toString()
            )
            respondFile(call, "server/serverFiles/$newFileName")
        } ?: run {
            call.respondRedirect(InsituApiRoutes.LOGIN)
        }
    }
}

fun Route.getUserInfoById() {
    get("${InsituApiRoutes.USER}/{userId}") {
        val userId = call.parameters["userId"]
        val authHeader = call.request.parseAuthorizationHeader()
        val requestingUserInfo: UserInfo? = if (!(authHeader == null
                    || authHeader !is HttpAuthHeader.Single
                    || authHeader.authScheme != "Bearer")
        ) {
            HttpClient.verifyToken(authHeader.blob)
        } else null

        if (requestingUserInfo != null) {
            val tokenInfo: TokenInfo? = HttpClient.client.submitForm(
                url = AuthApiSettings.MASTER_TOKEN_ENDPOINT,
                formParameters = Parameters.build {
                    append("grant_type", "password")
                    append("username", adminUser)
                    append("password", adminPassword)
                    append("client_id", "admin-cli")
                }
            ).body()

            tokenInfo?.let {
                var errorMessage: String = ""
                val userInfo: UserInfo? = try {
                    HttpClient.client.get("${AuthApiSettings.MASTER_USERS_ENDPOINT}/$userId")
                    {
                        headers.append(
                            HttpHeaders.Authorization,
                            "Bearer ${it.accessToken}"
                        )
                    }.body()
                } catch (ex: Exception) {
                    errorMessage = ex.localizedMessage ?: "error"
                    null
                }
                call.respond(
                    userInfo ?: errorMessage
                )
            }
        } else {
            call.response.headers.append("WWW-Authenticate", "Bearer realm=\"INSITU\"")
            call.response.status(HttpStatusCode.Unauthorized)
            call.respond("No valid token!")
        }
    }
}