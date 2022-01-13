package com.todoist.pojo

open class WorkspaceProject @JvmOverloads constructor(
    id: Long,
    open var v2Id: String? = null,
    open var name: String,
    open var description: String? = null,
    open var status: Project.Status = Project.Status.Planned,
    open var color: Int = Colors.DEFAULT_COLOR_ID,
    open var totalTasksCount: Int,
    open var uncompletedTasksCount: Int,
) : Model(id, false) {
    open val colorInt get() = Colors.getColor(color)
}
