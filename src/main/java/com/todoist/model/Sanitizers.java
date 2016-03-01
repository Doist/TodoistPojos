package com.todoist.model;

import java.util.regex.Pattern;

public class Sanitizers {
    public static final String PROJECT_NAME_INVALID_CHARACTERS = "<>\"=#+";
    public static final String LABEL_NAME_INVALID_CHARACTERS = "<>\"=#+\\s%!?~:@";
    public static final String FILTER_NAME_INVALID_CHARACTERS = "<>\"=#+";

    public static final Pattern PROJECT_NAME_INVALID_PATTERN =
            Pattern.compile("[" + PROJECT_NAME_INVALID_CHARACTERS + "]+");
    public static final Pattern LABEL_NAME_INVALID_PATTERN =
            Pattern.compile("[" + LABEL_NAME_INVALID_CHARACTERS + "]+");
    public static final Pattern FILTER_NAME_INVALID_PATTERN =
            Pattern.compile("[" + FILTER_NAME_INVALID_CHARACTERS + "]+");

    public static final String REPLACEMENT = "_";
}
