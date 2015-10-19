package com.todoist.model;

import java.util.regex.Pattern;

public class Sanitizers {
    static final Pattern PROJECT_NAME_INVALID_PATTERN = Pattern.compile("[<>\"=#+]+");
    static final Pattern LABEL_NAME_INVALID_PATTERN = Pattern.compile("[<>\"=#+\\s%!?~:]+");
    static final Pattern FILTER_NAME_INVALID_PATTERN = Pattern.compile("[<>\"=#+]+");

    static final String PROJECT_NAME_INVALID_REPLACEMENT = " ";
    static final String LABEL_NAME_INVALID_REPLACEMENT = "_";
    static final String FILTER_NAME_INVALID_REPLACEMENT = " ";
}
