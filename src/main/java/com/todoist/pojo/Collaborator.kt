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
    var projectsActive: Set<Long> = Utils.unmodifiableSet(projectsActive)
        private set
    /**
     * @return Unmodifiable set of invited project ids.
     */
    var projectsInvited: Set<Long> = Utils.unmodifiableSet(projectsInvited)
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
                projectsActive = Utils.unmodifiableSetWithElement(projectsActive, projectId)
                projectsInvited = Utils.unmodifiableSetWithoutElement(projectsInvited, projectId)
            }

            STATE_INVITED -> {
                projectsActive = Utils.unmodifiableSetWithoutElement(projectsActive, projectId)
                projectsInvited = Utils.unmodifiableSetWithElement(projectsInvited, projectId)
            }

            STATE_DELETED -> {
                projectsActive = Utils.unmodifiableSetWithoutElement(projectsActive, projectId)
                projectsInvited = Utils.unmodifiableSetWithoutElement(projectsInvited, projectId)
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
        this.projectsActive = Utils.unmodifiableSet(projectsActive)
    }

    /**
     * Copies the invited project ids into an unmodifiable set.
     *
     * @see {@link .setProjectState
     */
    fun setProjectsInvited(projectsInvited: Collection<Long>) {
        this.projectsInvited = Utils.unmodifiableSet(projectsInvited)
    }

    companion object {
        const val STATE_ACTIVE = "active"
        const val STATE_INVITED = "invited"
        const val STATE_DELETED = "deleted"
    }
}
