package com.todoist.pojo

open class Collaborator @JvmOverloads constructor(
    id: Long,
    email: String,
    fullName: String = "",
    imageId: String? = null,
    open var projectsActive: Set<Long> = emptySet(),
    open var projectsInvited: Set<Long> = emptySet(),
    isDeleted: Boolean = false
) : Person(id, email, fullName, imageId, isDeleted) {

    fun getProjectState(projectId: Long) = when (projectId) {
        in projectsActive -> STATE_ACTIVE
        in projectsInvited -> STATE_INVITED
        else -> STATE_DELETED
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

    sealed class Role(protected open val key: String) {
        object Creator : Role("CREATOR")

        object Admin : Role("ADMIN")

        object ReadWrite : Role("READ_WRITE")

        object ReadAndComment : Role("READ_AND_COMMENT")

        object ReadOnly : Role("READ_ONLY")

        data class Unknown(override val key: String) : Role(key)

        object Invalid : Role("INVALID")

        override fun toString() = key

        companion object {
            fun get(typeKey: String?): Role {
                val upperCasedKey = typeKey?.uppercase()
                return when {
                    upperCasedKey.isNullOrEmpty() -> Invalid
                    upperCasedKey == Creator.key -> Creator
                    upperCasedKey == Admin.key -> Admin
                    upperCasedKey == ReadWrite.key -> ReadWrite
                    upperCasedKey == ReadAndComment.key -> ReadAndComment
                    upperCasedKey == ReadOnly.key -> ReadOnly
                    else -> Unknown(typeKey)
                }
            }
        }
    }

    companion object {
        const val STATE_ACTIVE = "active"
        const val STATE_INVITED = "invited"
        const val STATE_DELETED = "deleted"
    }
}
