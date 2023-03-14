package p20.insitu.com.authApi

import p20.insitu.util.DEV_AUTH_PORT
import p20.insitu.util.DEV_BASE_URL

object AuthApiSettings {
    // OAuth / Openid Server
    private const val BASE_AUTH_URL = DEV_BASE_URL // TODO change for production
    private const val AUTH_PORT = DEV_AUTH_PORT // TODO change for production
    const val AUTH_URL = "http://$BASE_AUTH_URL:$AUTH_PORT"
    const val AUTH_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/realms/INSITU/protocol/openid-connect/auth"
    const val TOKEN_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/realms/INSITU/protocol/openid-connect/token"
    const val LOGOUT_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/realms/INSITU/protocol/openid-connect/logout"
    const val USER_INFO_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/realms/INSITU/protocol/openid-connect/userinfo"
    const val CERTIFICATE_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/realms/INSITU/protocol/openid-connect/certs"


    const val MASTER_TOKEN_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/realms/master/protocol/openid-connect/token"
    const val MASTER_USERS_ENDPOINT =
        "${AuthApiSettings.AUTH_URL}/admin/realms/INSITU/users"

    const val DI_AUTH_API = "auth_api"

    const val USER_SESSION_COOKIE = "user_session"
    const val KEYCLOAK_OATUH = "keycloakOAuth"
}

