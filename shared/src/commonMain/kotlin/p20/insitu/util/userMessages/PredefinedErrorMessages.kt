package p20.insitu.util.userMessages

import p20.insitu.resources.Language
import p20.insitu.resources.strings.MessageStrings

object PredefinedErrorMessages {
    fun NOT_YET_AVAILABEL(language: Language, relatedUserAction: UserAction = UserAction.NONE): UserMessage = UserMessage(message = MessageStrings.featureNotImplementedYet(language), relatedUserAction = relatedUserAction)
    fun UNKNOWN_ERROR(language: Language, relatedUserAction: UserAction = UserAction.NONE): UserMessage = UserMessage(message = MessageStrings.unknownError(language), relatedUserAction = relatedUserAction)
    fun NO_INSITU_SERVICE_AVAILABLE(language: Language, relatedUserAction: UserAction = UserAction.RETRY): UserMessage = UserMessage(message = MessageStrings.insituServiceUnavailable(language), relatedUserAction = relatedUserAction)
    fun SUCCESSFULL(language: Language, relatedUserAction: UserAction = UserAction.NONE): UserMessage = UserMessage(message = MessageStrings.deleted_successfully(language), relatedUserAction = relatedUserAction)
}