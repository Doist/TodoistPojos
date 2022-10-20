package com.todoist.pojo

open class WorkspaceUser(
    id: String,
    open var workspaceId: String,
    open var email: String,
    open var fullName: String?,
    open var timeZone: String?,
    open var imageId: String?,
    open var workspaceRole: Workspace.Role,
    isDeleted: Boolean,
) : Model(id, isDeleted)
