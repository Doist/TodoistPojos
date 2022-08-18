package com.todoist.pojo

open class NavigationCustomization<F : Feature>(
    open val features: List<F>,
    open val isCountsShown: Boolean
)
