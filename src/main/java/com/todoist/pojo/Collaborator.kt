package com.todoist.pojo

open class Collaborator @JvmOverloads constructor(
        id: Long,
        email: String,
        fullName: String = "",
        imageId: String? = null,
        projectsActive: Collection<Long>? = null,
        projectsInvited: Collection<Long>? = null,
        isDeleted: Boolean = false
) : Person(id, email, fullName, imageId, isDeleted) {
    var projectsActive: Set<Long> = projectsActive.orEmpty().toSet()

    var projectsInvited: Set<Long> = projectsInvited.orEmpty().toSet()

    fun getProjectState(projectId: Long): String {
        return when {
            projectsActive.contains(projectId) -> STATE_ACTIVE
            projectsInvited.contains(projectId) -> STATE_INVITED
            else -> STATE_DELETED
        }
    }

    open fun setProjectState(projectId: Long, state: String) {
        when (state) {
            STATE_ACTIVE -> {
                projectsActive = projectsActive + projectId
                projectsInvited = projectsInvited - projectId
            }

            STATE_INVITED -> {
                projectsActive = projectsActive - projectId
                projectsInvited = projectsInvited + projectId
            }

            STATE_DELETED -> {
                projectsActive = projectsActive - projectId
                projectsInvited = projectsInvited - projectId
            }

            else -> throw IllegalArgumentException("Unknown state.")
        }
    }

    companion object {
        const val STATE_ACTIVE = "active"
        const val STATE_INVITED = "invited"
        const val STATE_DELETED = "deleted"
    }
}
