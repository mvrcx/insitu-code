package p20.insitu.viewmodels

import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.coroutines.flow.StateFlow
import p20.insitu.model.entities.Audio
import p20.insitu.model.entities.Image
import p20.insitu.model.entities.Note
import p20.insitu.model.entities.Video

interface MediaViewModel {

    val notes: StateFlow<List<Note>>
    val notesNested: StateFlow<List<Note>>
    val notesFiltered: StateFlow<List<Note>>

    val images: StateFlow<List<Image>>
    val imagesNested: StateFlow<List<Image>>

    val imageBitmaps: StateFlow<Map<String, ImageBitmap>>
    val imageBitmapsNested: StateFlow<Map<String, ImageBitmap>>

    val audioRecordings: StateFlow<List<Audio>>
    val audioRecordingsNested: StateFlow<List<Audio>>

    val videos: StateFlow<List<Video>>
    val videosNested: StateFlow<List<Video>>
}