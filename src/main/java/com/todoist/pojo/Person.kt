package com.todoist.pojo

import java.util.regex.Pattern

open class Person(
        id: Long,
        open var email: String,
        open var fullName: String = "",
        open var imageId: String?,
        deleted: Boolean
) : TodoistObject(id, deleted) {

    val defaultAvatarText: String
        get() = getDefaultAvatarText(fullName)

    fun getDefaultAvatarColorInt(useLightColors: Boolean): Int = getDefaultAvatarColorInt(email, useLightColors)

    companion object {
        /* Matches leading and trailing spaces and special characters commonly found in name fields. */
        private val ESCAPE_PATTERN = Pattern.compile("^\\s+|\\s+$|[\\(\\)\\.,\\-_\\[\\]'\"]")

        private val LIGHT_AVATAR_COLORS = longArrayOf(0XFFE9952C, 0XFFE16B2D, 0XFFD84B40, 0XFFE8435A, 0XFFE5198A,
                                                     0XFFAD3889, 0XFF86389C, 0XFF98BE2F, 0XFF5D9D50, 0XFF5F9F85,
                                                     0XFF5BBCB6, 0XFF32A3BF, 0XFF2BAFEB, 0XFF2D88C3, 0XFF3863CC,
                                                     0XFF5E5E5E)

        private val DARK_AVATAR_COLORS = longArrayOf(0XFFFCC652, 0XFFE9952C, 0XFFE16B2D, 0XFFD84B40, 0XFFE8435A,
                                                    0XFFE5198A, 0XFFAD3889, 0XFFA8A8A8, 0XFF98BE2F, 0XFF5D9D50,
                                                    0XFF5F9F85, 0XFF5BBCB6, 0XFF32A3BF, 0XFF2BAFEB, 0XFF2D88C3)


        @JvmStatic fun getDefaultAvatarColorInt(email: String?, useLightColors: Boolean): Int {
            if (email != null) {
                val atIndex = email.indexOf("@")
                if (atIndex > 0) {
                    val colors = getAvatarColors(useLightColors)
                    return colors[(email[0].toInt() + email[atIndex - 1].toInt()).rem(colors.size)].toInt()
                }
            }

            return 0xFF000000.toInt()
        }

        private fun getAvatarColors(useLightColors: Boolean): LongArray {
            return if (useLightColors) LIGHT_AVATAR_COLORS else DARK_AVATAR_COLORS
        }

        @JvmStatic fun getDefaultAvatarText(fullName: String?): String {
            if (fullName != null) {
                val names = ESCAPE_PATTERN.matcher(fullName).replaceAll("").split(
                        "\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                if (names.isNotEmpty()) {
                    val initials = StringBuilder(2)

                    val firstName = names[0]
                    if (firstName.isNotEmpty()) {
                        initials.append(Character.toUpperCase(firstName[0]))
                    }

                    if (names.size > 1) {
                        val lastName = names[names.size - 1]
                        if (lastName.isNotEmpty()) {
                            initials.append(Character.toUpperCase(lastName[0]))
                        }
                    }

                    if (initials.isNotEmpty()) {
                        return initials.toString()
                    }
                }
            }

            return "?"
        }
    }
}
