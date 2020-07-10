package com.todoist.pojo

/**
 * Available colors, as ARGB ints.
 */
@ExperimentalUnsignedTypes
object Colors {
    const val BERRY_RED = 0xFFB8255Fu
    const val RED = 0xFFDB4035u
    const val ORANGE = 0xFFFF9933u
    const val YELLOW = 0xFFFAD000u
    const val OLIVE_GREEN = 0xFFAFB83Bu
    const val LIME_GREEN = 0xFF7ECC49u
    const val GREEN = 0xFF299438u
    const val MINT_GREEN = 0xFF6ACCBCu
    const val TEAL = 0xFF158FADu
    const val SKY_BLUE = 0xFF14AAF5u
    const val LIGHT_BLUE = 0xFF96C3EBu
    const val BLUE = 0xFF4073FFu
    const val GRAPE = 0xFF884DFFu
    const val VIOLET = 0xFFAF38EBu
    const val LAVENDER = 0xFFEB96EBu
    const val MAGENTA = 0xFFE05194u
    const val SALMON = 0xFFFF8D85u
    const val CHARCOAL = 0xFF808080u
    const val GRAY = 0xFFB8B8B8u
    const val TAUPE = 0xFFCCAC93u

    const val DEFAULT_COLOR_ID = 48 // GRAY.

    private val COLORS = uintArrayOf(
        BERRY_RED, RED, ORANGE, YELLOW, OLIVE_GREEN, LIME_GREEN, GREEN, MINT_GREEN, TEAL,
        SKY_BLUE, LIGHT_BLUE, BLUE, GRAPE, VIOLET, LAVENDER, MAGENTA, SALMON, CHARCOAL,
        GRAY, TAUPE
    ).toIntArray()

    fun getColor(colorId: Int): Int {
        // Color ids start at 30. Subtract that value, so it can be mapped to the array's index.
        val colorIndex = colorId - 30
        return if (colorIndex >= 0 && colorIndex < COLORS.size) COLORS[colorIndex] else GRAY.toInt()
    }
}
