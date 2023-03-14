package p20.insitu.com

import p20.insitu.com.authApi.authApiModule
import p20.insitu.com.catalogApi.catalogApiModule
import p20.insitu.com.gisApi.gisApiModule
import p20.insitu.com.insituApi.insituApiModule

val comModules = listOf(
    authApiModule,
    catalogApiModule,
    gisApiModule,
    insituApiModule
)