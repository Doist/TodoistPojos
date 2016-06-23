package com.todoist.model;

public class BaseFileAttachment {
    /**
     * The upload is currently pending, meaning it's waiting for upload, currently being uploaded, or the upload failed
     * but the user hasn't chosen to retry or cancel.
     */
    public static final String UPLOAD_STATE_PENDING = "pending";
    /**
     * The upload has been successfully completed.
     */
    public static final String UPLOAD_STATE_COMPLETED = "completed";
    /**
     * The upload has failed and the user chose to cancel it.
     */
    public static final String UPLOAD_STATE_CANCELED = "canceled";

    private String fileUrl;
    private String fileName;
    private String fileType;
    private String resourceType;
    private String uploadState;
    private Long fileSize;
    private Long fileDuration;
    private String image;
    private Integer imageWidth;
    private Integer imageHeight;
    private String url;
    private String title;
    private String description;

    public BaseFileAttachment(String resourceType, String fileUrl, String fileName, String fileType, String uploadState,
                              Long fileSize, Long fileDuration, String image, Integer imageWidth, Integer imageHeight,
                              String url, String title, String description) {
        this.resourceType = resourceType;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileType = fileType;
        this.uploadState = uploadState;
        this.fileSize = fileSize;
        this.fileDuration = fileDuration;
        this.image = image;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.url = url;
        this.title = title;
        this.description = description;
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
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

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getFileDuration() {
        return fileDuration;
    }

    public void setFileDuration(Long fileDuration) {
        this.fileDuration = fileDuration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
