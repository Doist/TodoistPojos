package com.todoist.pojo

open class QuickAddCustomization<F : Feature>(
    open val features: List<F>,
    open val isLabelsShown: Boolean
)
