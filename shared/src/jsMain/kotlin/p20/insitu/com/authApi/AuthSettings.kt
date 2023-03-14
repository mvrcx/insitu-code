package p20.insitu.com.authApi

actual fun authRedirectUri(): String = "${ApiSettings.SERVER_URL}/callback"