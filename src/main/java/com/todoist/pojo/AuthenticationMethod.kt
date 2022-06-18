package com.todoist.pojo

open class AuthenticationMethod(
    val methodType: AuthenticationMethodType,
    val secret: String,
    val url: String,
    val barcode: String,
)

