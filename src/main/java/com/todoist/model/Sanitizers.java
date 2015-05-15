package com.todoist.model;

import java.util.regex.Pattern;

public class Sanitizers {
    static final Pattern PROJECT_NAME_INVALID_PATTERN = Pattern.compile("[+#]+");
    static final Pattern LABEL_NAME_INVALID_PATTERN = Pattern.compile("[\\s%!~:+#]+");
}
