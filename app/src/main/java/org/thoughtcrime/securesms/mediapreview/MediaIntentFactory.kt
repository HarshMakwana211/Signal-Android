package org.thoughtcrime.securesms.mediapreview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object MediaIntentFactory {
  private const val ARGS_KEY = "args"

  const val NOT_IN_A_THREAD = -2
  const val UNKNOWN_TIMESTAMP = -2
  const val THREAD_ID_EXTRA = "thread_id"
  const val DATE_EXTRA = "date"
  const val SIZE_EXTRA = "size"
  const val CAPTION_EXTRA = "caption"
  const val LEFT_IS_RECENT_EXTRA = "left_is_recent"
  const val HIDE_ALL_MEDIA_EXTRA = "came_from_all_media"
  const val SHOW_THREAD_EXTRA = "show_thread"
  const val SORTING_EXTRA = "sorting"
  const val IS_VIDEO_GIF = "is_video_gif"

  @Parcelize
  data class MediaPreviewArgs(
    val threadId: Long,
    val date: Long,
    val initialMediaUri: Uri,
    val initialMediaType: String,
    val initialMediaSize: Long,
    val initialCaption: String? = null,
    val leftIsRecent: Boolean = false,
    val hideAllMedia: Boolean = false,
    val showThread: Boolean = false,
    val allMediaInRail: Boolean = false,
    val sorting: Int,
    val isVideoGif: Boolean
  ) : Parcelable

  @JvmStatic
  fun requireArguments(bundle: Bundle): MediaPreviewArgs = bundle.getParcelable(ARGS_KEY)!!

  @JvmStatic
  fun create(context: Context, args: MediaPreviewArgs): Intent {
    return Intent(context, MediaPreviewV2Activity::class.java).putExtra(ARGS_KEY, args)
  }
}
