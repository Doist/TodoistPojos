package com.todoist.pojo

open class Collaborator @JvmOverloads constructor(
        id: Long,
        email: String,
        fullName: String = "",
        imageId: String? = null,
        projectsActive: Collection<Long>? = null,
        projectsInvited: Collection<Long>? = null,
        deleted: Boolean = false
) : Person(id, email, fullName, imageId, deleted) {

    /**
     * @return Unmodifiable set of active project ids.
     */
    var projectsActive: Set<Long> = projectsActive.orEmpty().toSet()
        private set
    /**
     * @return Unmodifiable set of invited project ids.
     */
    var projectsInvited: Set<Long> = projectsInvited.orEmpty().toSet()
        private set

    fun getProjectState(projectId: Long): String {
        return when {
            projectsActive.contains(projectId) -> STATE_ACTIVE
            projectsInvited.contains(projectId) -> STATE_INVITED
            else -> STATE_DELETED
        }
    }

    /**
     * Sets the state for a specific project id.
     */
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

    /**
     * Copies the active project ids into an unmodifiable set.
     *
     * @see {@link .setProjectState
     */
    fun setProjectsActive(projectsActive: Collection<Long>) {
        this.projectsActive = projectsActive.toSet()
    }

    /**
     * Copies the invited project ids into an unmodifiable set.
     *
     * @see {@link .setProjectState
     */
    fun setProjectsInvited(projectsInvited: Collection<Long>) {
        this.projectsInvited = projectsInvited.toSet()
    }

    companion object {
        const val STATE_ACTIVE = "active"
        const val STATE_INVITED = "invited"
        const val STATE_DELETED = "deleted"
    }
}
