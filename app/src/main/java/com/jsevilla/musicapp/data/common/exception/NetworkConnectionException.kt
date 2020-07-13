package com.jsevilla.musicapp.data.common.exception

class NetworkConnectionException : ServiceException {
    constructor() : super("No hay conexión a internet.") {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}

    companion object {
        private const val TAG = "NetworkConnectionException"
    }
}