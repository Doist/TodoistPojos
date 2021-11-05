package com.todoist.pojo

class Workspace {
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
}
