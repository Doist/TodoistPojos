package com.todoist.pojo

open class Tooltips(
    open val scheduled: Set<String> = emptySet(),
    open val seen: Set<String> = emptySet()
)
