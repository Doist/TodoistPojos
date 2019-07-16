package com.todoist.pojo

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PersonTest {
    @Test
    fun getDefaultAvatarText() {
        listOf("First Last" to "FL",
               "Not capitalized" to "NC",
               " White\n\nSpace  " to "WS",
               "ã ž" to "ÃŽ",
               "Ludwig van Beethoven" to "LB",
               "[Spe-cial], (Chars)" to "SC",
               "Mononym" to "M",
               "Q" to "Q",
               "  " to "?"
        ).forEach { (fullName, defaultAvatarText) ->
            assertEquals(defaultAvatarText, Person.getDefaultAvatarText(fullName))
        }
    }
}