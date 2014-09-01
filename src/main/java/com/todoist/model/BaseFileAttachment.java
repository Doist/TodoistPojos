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

    private String url;
    private String name;
    private String type;
    private String underlyingType;
    private Long size;
    private String uploadState;
    private BaseThumbnail thumbnailSmall;
    private BaseThumbnail thumbnailMedium;
    private BaseThumbnail thumbnailLarge;

    public BaseFileAttachment(String url, String name, String type, String underlyingType, Long size,
                              String uploadState, BaseThumbnail thumbnailSmall,
                              BaseThumbnail thumbnailMedium, BaseThumbnail thumbnailLarge) {
        this.url = url;
        this.name = name;
        this.type = type;
        this.underlyingType = underlyingType;
        this.size = size;
        this.uploadState = uploadState;
        this.thumbnailSmall = thumbnailSmall;
        this.thumbnailMedium = thumbnailMedium;
        this.thumbnailLarge = thumbnailLarge;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnderlyingType() {
        return underlyingType;
    }

    public void setUnderlyingType(String underlyingType) {
        this.underlyingType = underlyingType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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
