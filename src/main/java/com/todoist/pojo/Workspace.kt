package com.todoist.pojo

open class Workspace(
    id: String,
    open var name: String,
    open var description: String?,
    open var logoBig: String?,
    open var logoMedium: String?,
    open var logoSmall: String?,
    open var logoS640: String?,
    open var isInviteOnlyDefault: Boolean,
    open var defaultCollaboratorRole: Collaborator.Role,
    open var createdAt: Long,
    open var isCollapsed: Boolean,
    isDeleted: Boolean,
) : Model(id, isDeleted) {
    sealed class Role(protected open val key: String) {
        object Admin : Role("ADMIN")

        object Member : Role("MEMBER")

        object Guest : Role("GUEST")

        data class Unknown(override val key: String) : Role(key)

        object Invalid : Role("INVALID")

        override fun toString() = key

        companion object {
            fun get(typeKey: String?): Role {
                val upperCasedKey = typeKey?.uppercase()
                return when {
                    upperCasedKey.isNullOrEmpty() -> Invalid
                    upperCasedKey == Admin.key -> Admin
                    upperCasedKey == Member.key -> Member
                    upperCasedKey == Guest.key -> Guest
                    else -> Unknown(typeKey)
                }
            }
        }
    }

    companion object {
        fun sanitizeName(name: String): String =
            Sanitizers.WORKSPACE_NAME_INVALID_PATTERN.matcher(name.trim())
                .replaceAll(Sanitizers.REPLACEMENT)
    }
}
