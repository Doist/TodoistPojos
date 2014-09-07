package com.todoist.model;

public class BaseFileAttachment {
    /**
     * Merely indicative. There's no guarantee the actual small thumbnail will have this size.
     * */
    public static final int THUMBNAIL_SMALL_SIZE = 96;
    /**
     * Merely indicative. There's no guarantee the actual medium thumbnail will have this size.
     * */
    public static final int THUMBNAIL_MEDIUM_SIZE = 288;
    /**
     * Merely indicative. There's no guarantee the actual large thumbnail will have this size.
     * */
    public static final int THUMBNAIL_LARGE_SIZE = 528;

    /**
     * The upload is currently pending, meaning it's waiting for upload, currently being uploaded, or the upload failed
     * but the user hasn't chosen to retry or cancel.
     */
    public static final String UPLOAD_STATE_PENDING = "pending";
    /**
     * The upload has been successfully completed.
     * */
    public static final String UPLOAD_STATE_COMPLETED = "completed";
    /**
     * The upload has failed and the user chose to cancel it.
     */
    public static final String UPLOAD_STATE_CANCELED = "canceled";

    private String fileUrl;
    private String fileName;
    private String fileType;
    private String fileUnderlyingType;
    private Long fileSize;
    private String uploadState;
    private BaseThumbnail thumbnailSmall;
    private BaseThumbnail thumbnailMedium;
    private BaseThumbnail thumbnailLarge;

    public BaseFileAttachment(String fileUrl, String fileName, String fileType, String fileUnderlyingType, Long fileSize,
                              String uploadState, BaseThumbnail thumbnailSmall,
                              BaseThumbnail thumbnailMedium, BaseThumbnail thumbnailLarge) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUnderlyingType = fileUnderlyingType;
        this.fileSize = fileSize;
        this.uploadState = uploadState;
        this.thumbnailSmall = thumbnailSmall;
        this.thumbnailMedium = thumbnailMedium;
        this.thumbnailLarge = thumbnailLarge;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUnderlyingType() {
        return fileUnderlyingType;
    }

    public void setFileUnderlyingType(String fileUnderlyingType) {
        this.fileUnderlyingType = fileUnderlyingType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadState() {
        return uploadState;
    }

    public boolean isUploadCompleted() {
        return Utils.equals(uploadState, UPLOAD_STATE_COMPLETED);
    }

    public boolean isUploadCanceled() {
        return Utils.equals(uploadState, UPLOAD_STATE_CANCELED);
    }

    public boolean isUploadPending() {
        return Utils.equals(uploadState, UPLOAD_STATE_PENDING);
    }

    public void setUploadState(String uploadState) {
        this.uploadState = uploadState;
    }

    public BaseThumbnail getThumbnailSmall() {
        return thumbnailSmall;
    }

    public void setThumbnailSmall(BaseThumbnail thumbnailSmall) {
        this.thumbnailSmall = thumbnailSmall;
    }

    public BaseThumbnail getThumbnailMedium() {
        return thumbnailMedium;
    }

    public void setThumbnailMedium(BaseThumbnail thumbnailMedium) {
        this.thumbnailMedium = thumbnailMedium;
    }

    public BaseThumbnail getThumbnailLarge() {
        return thumbnailLarge;
    }

    public void setThumbnailLarge(BaseThumbnail thumbnailLarge) {
        this.thumbnailLarge = thumbnailLarge;
    }
}
