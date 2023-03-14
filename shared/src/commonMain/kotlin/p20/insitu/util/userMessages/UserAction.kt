package p20.insitu.util.userMessages

enum class UserAction(val actionLabel: String?) {
    NONE(actionLabel = null),
    OK(actionLabel = "Ok"),
    RETRY(actionLabel = "Wiederholen"),
    ABORT(actionLabel = "Abbruch")
}