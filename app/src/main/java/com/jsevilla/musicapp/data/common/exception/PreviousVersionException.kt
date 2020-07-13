package pe.iqproject.library.net.exception

class PreviousVersionException : ServiceException {
    var isRequiredUpdate = false
        private set
    var url: String? = null
        private set

    constructor() : super() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}
    constructor(message: String?, requiredUpdate: Boolean) : super(message) {
        isRequiredUpdate = requiredUpdate
    }

    constructor(
        message: String?,
        url: String?,
        requiredUpdate: Boolean,
        cause: Throwable?
    ) : super(message, cause) {
        this.url = url
        isRequiredUpdate = requiredUpdate
    }

    companion object {
        private const val TAG = "PreviousVersionException"
    }
}