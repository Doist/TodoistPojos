package com.todoist.pojo

enum class AuthenticationMethodType(val key: String) {
    TOTP("totp"),
    BACKUP_CODE("backup_code");
}
