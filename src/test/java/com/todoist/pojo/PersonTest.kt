package com.todoist.pojo

import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun getDefaultAvatarText() {
        listOf(
            Triple("First Last", "test@doist.com", "FL"),
            Triple("Not capitalized", "test@doist.com", "NC"),
            Triple(" White\n\nSpace  ", "test@doist.com", "WS"),
            Triple("ã ž", "test@doist.com", "ÃŽ"),
            Triple("Ludwig van Beethoven", "test@doist.com", "LB"),
            Triple("[Spe-cial], (Chars)", "test@doist.com", "SC"),
            Triple("\u00A0NO-BREAK\u00A0SPACE\u00A0", "test@doist.com", "NS"),
            Triple("Mononym", "test@doist.com", "M"),
            Triple("Q", "test@doist.com", "Q"),
            Triple("  ", "test@doist.com", "T"),
        ).forEach { (fullName, email, defaultAvatarText) ->
            assertEquals(defaultAvatarText, Person.getDefaultAvatarText(fullName, email))
        }
    }
}
