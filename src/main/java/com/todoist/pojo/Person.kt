package com.todoist.pojo

open class Person(
    id: Long,
    open var email: String,
    open var fullName: String = "",
    open var imageId: String?,
    isDeleted: Boolean
) : Model(id, isDeleted) {
    val defaultAvatarText get() = getDefaultAvatarText(fullName, email)

    fun getDefaultAvatarColorInt(useLightColors: Boolean) =
        getDefaultAvatarColorInt(email, useLightColors)

    companion object {
        // Matches special characters commonly found in name fields.
        private val ESCAPE_PATTERN = Regex("""[().,\-_\[\]'"]""")

        private val LIGHT_AVATAR_COLORS = uintArrayOf(
            0XFFE9952Cu,
            0XFFE16B2Du,
            0XFFD84B40u,
            0XFFE8435Au,
            0XFFE5198Au,
            0XFFAD3889u,
            0XFF86389Cu,
            0XFF98BE2Fu,
            0XFF5D9D50u,
            0XFF5F9F85u,
            0XFF5BBCB6u,
            0XFF32A3BFu,
            0XFF2BAFEBu,
            0XFF2D88C3u,
            0XFF3863CCu,
            0XFF5E5E5Eu
        ).toIntArray()

        private val DARK_AVATAR_COLORS = uintArrayOf(
            0XFFFCC652u,
            0XFFE9952Cu,
            0XFFE16B2Du,
            0XFFD84B40u,
            0XFFE8435Au,
            0XFFE5198Au,
            0XFFAD3889u,
            0XFFA8A8A8u,
            0XFF98BE2Fu,
            0XFF5D9D50u,
            0XFF5F9F85u,
            0XFF5BBCB6u,
            0XFF32A3BFu,
            0XFF2BAFEBu,
            0XFF2D88C3u
        ).toIntArray()

        @JvmStatic
        fun getDefaultAvatarColorInt(email: String, useLightColors: Boolean): Int {
            val atIndex = email.indexOf('@')
            if (atIndex <= 0) return 0xFF000000u.toInt()

            val colors = if (useLightColors) LIGHT_AVATAR_COLORS else DARK_AVATAR_COLORS
            val index = (email[0].code + email[atIndex - 1].code) % colors.size
            return colors[index]
        }

        @JvmStatic
        fun getDefaultAvatarText(fullName: String?, email: String?): String {
            val escapedName = fullName?.replace(ESCAPE_PATTERN, "")?.trim().orEmpty()
            if (escapedName.isBlank()) {
                return getEmailInitials(email)
            }

            val first = escapedName[0].uppercaseChar()
            val lastSpace = escapedName.indexOfLast { it.isWhitespace() }
            val last =
                if (lastSpace != -1) escapedName[lastSpace + 1].uppercaseChar().toString() else ""
            return first + last
        }

        private fun getEmailInitials(email: String?): String {
            val validEmail = email ?: "?"
            return buildString {
                val emailInitials = validEmail.substringBefore("@")
                    .split(".")
                    .filter { it.isNotEmpty() }
                    .map { emailPart -> emailPart.first().uppercase() }
                append(emailInitials.firstOrNull().orEmpty())
                if (emailInitials.size > 1) {
                    append(emailInitials.lastOrNull().orEmpty())
                }
            }
        }
    }
}
