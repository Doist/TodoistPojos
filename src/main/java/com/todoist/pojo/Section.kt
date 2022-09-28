package com.todoist.pojo

open class Section @JvmOverloads constructor(
    id: String,
    open var v2Id: String? = null,
    open var name: String,
    open var projectId: String,
    open var sectionOrder: Int = 0,
    open var isCollapsed: Boolean = false,
    open var dateAdded: Long = 0,
    open var isArchived: Boolean = false,
    open var dateArchived: Long? = null,
    isDeleted: Boolean = false
) : Model(id, isDeleted) {
    companion object {
        const val DEFAULT_CHILD_ORDER = 1
        const val MIN_DEPTH = 0

        @JvmStatic
        fun sanitizeName(name: String): String =
            Sanitizers.SECTION_NAME_INVALID_PATTERN.matcher(name.trim())
                .replaceAll(Sanitizers.REPLACEMENT)
    }
}
