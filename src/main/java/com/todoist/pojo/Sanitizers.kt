package com.todoist.pojo

import java.util.regex.Pattern

object Sanitizers {
    const val PROJECT_NAME_INVALID_CHARACTERS = "<>\"=#+"
    const val LABEL_NAME_INVALID_CHARACTERS = "<>\"=#+\\s%!?~:@()"
    const val FILTER_NAME_INVALID_CHARACTERS = "<>\"=#+"

    @JvmField
    val PROJECT_NAME_INVALID_PATTERN = Pattern.compile("[$PROJECT_NAME_INVALID_CHARACTERS]+")
    @JvmField
    val LABEL_NAME_INVALID_PATTERN = Pattern.compile("[$LABEL_NAME_INVALID_CHARACTERS]+")
    @JvmField
    val FILTER_NAME_INVALID_PATTERN = Pattern.compile("[$FILTER_NAME_INVALID_CHARACTERS]+")

    const val REPLACEMENT = "_"
}
