package com.todoist.pojo;

/**
 * Available colors, as ARGB ints.
 */
public class Colors {
    public static final int BERRY_RED = 0xFFB8255F;
    public static final int RED = 0xFFDB4035;
    public static final int ORANGE = 0xFFFF9933;
    public static final int YELLOW = 0xFFFAD000;
    public static final int OLIVE_GREEN = 0xFFAFB83B;
    public static final int LIME_GREEN = 0xFF7ECC49;
    public static final int GREEN = 0xFF299438;
    public static final int MINT_GREEN = 0xFF6ACCBC;
    public static final int TEAL = 0xFF158FAD;
    public static final int SKY_BLUE = 0xFF14AAF5;
    public static final int LIGHT_BLUE = 0xFF96C3EB;
    public static final int BLUE = 0xFF4073FF;
    public static final int GRAPE = 0xFF884DFF;
    public static final int VIOLET = 0xFFAF38EB;
    public static final int LAVENDER = 0xFFEB96EB;
    public static final int MAGENTA = 0xFFE05194;
    public static final int SALMON = 0xFFFF8D85;
    public static final int CHARCOAL = 0xFF808080;
    public static final int GRAY = 0xFFB8B8B8;
    public static final int TAUPE = 0xFFCCAC93;

    public static final int DEFAULT_COLOR_ID = 48; // GRAY.

    private static final int[] COLORS = {
            BERRY_RED,
            RED,
            ORANGE,
            YELLOW,
            OLIVE_GREEN,
            LIME_GREEN,
            GREEN,
            MINT_GREEN,
            TEAL,
            SKY_BLUE,
            LIGHT_BLUE,
            BLUE,
            GRAPE,
            VIOLET,
            LAVENDER,
            MAGENTA,
            SALMON,
            CHARCOAL,
            GRAY,
            TAUPE
    };

    public static int getColor(int colorId) {
        // Color IDs start at 30. To simplify, subtract that value and it can be mapped to the array's index.
        colorId -= 30;

        return colorId >= 0 && colorId < COLORS.length ? COLORS[colorId] : GRAY;
    }
}