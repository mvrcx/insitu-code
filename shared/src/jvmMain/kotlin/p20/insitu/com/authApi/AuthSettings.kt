package p20.insitu.com.authApi

import p20.insitu.com.insituApi.InsituApiRoutes
import p20.insitu.com.insituApi.InsituApiSettings

actual fun authRedirectUri(): String = "${InsituApiSettings.SERVER_URL}${InsituApiRoutes.SUCCESSFUL_LOGIN}"