package p20.insitu.server

import p20.insitu.server.insitu.startInsituServer

fun main(args: Array<String>) {
//    initObjectDetectionModels()
    startServers()
    Runtime.getRuntime().addShutdownHook(Thread({ closeObjectDetectionModels() }, "Shutdown-thread"))
}

actual fun startServers(){
    startInsituServer()
    //startGisServer()
    //startCatalogServer()
}