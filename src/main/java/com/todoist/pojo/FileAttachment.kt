package com.todoist.pojo

open class FileAttachment(
        open var resourceType: String?,
        open var fileUrl: String?,
        open var fileName: String?,
        open var fileType: String?,
        open var uploadState: String?,
        open var fileSize: Long?,
        open var fileDuration: Long?,
        open var image: String?,
        open var imageWidth: Int?,
        open var imageHeight: Int?,
        open var url: String?,
        open var title: String?,
        open var description: String?
) {
    val isUploadCompleted get() = uploadState == UPLOAD_STATE_COMPLETED
    val isUploadCanceled get() = uploadState == UPLOAD_STATE_CANCELED
    val isUploadPending get() = uploadState == UPLOAD_STATE_PENDING

    companion object {
        const val RESOURCE_TYPE_FILE = "file"
        const val RESOURCE_TYPE_IMAGE = "image"
        const val RESOURCE_TYPE_VIDEO = "video"
        const val RESOURCE_TYPE_AUDIO = "audio"
        const val RESOURCE_TYPE_WEBSITE = "website"

        /**
         * The upload is currently pending, meaning it's waiting for upload, currently being uploaded, or the upload failed
         * but the user hasn't chosen to retry or cancel.
         */
        const val UPLOAD_STATE_PENDING = "pending"
        /**
         * The upload has been successfully completed.
         */
        const val UPLOAD_STATE_COMPLETED = "completed"
        /**
         * The upload has failed and the user chose to cancel it.
         */
        const val UPLOAD_STATE_CANCELED = "canceled"
    }
}
