package com.jsevilla.musicapp.data.common.exception

class UnauthorizedException : ServiceException {
    constructor() : super() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}

    companion object {
        private const val TAG = "UnauthorizedException"
    }
}