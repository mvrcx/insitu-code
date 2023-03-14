package p20.insitu.android.ui.media.recordings

sealed class VideoRecorderUIAction {
    object OnSwitchRecorderClick : VideoRecorderUIAction()
    object OnStartRecordVideoClick : VideoRecorderUIAction()
    object OnStopRecordVideoClick : VideoRecorderUIAction()
    object OnToogleAudioRecordingClick : VideoRecorderUIAction()
}