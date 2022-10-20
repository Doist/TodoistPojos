package com.todoist.pojo

open class Collaborator @JvmOverloads constructor(
    id: String,
    email: String,
    fullName: String = "",
    imageId: String? = null,
    isDeleted: Boolean = false
) : Person(id, email, fullName, imageId, isDeleted) {
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
