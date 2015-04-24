package com.todoist.model;

import java.util.regex.Pattern;

public class Sanitizers {
    static final Pattern PROJECT_NAME = Pattern.compile("[+#]+");
    static final Pattern LABEL_NAME = Pattern.compile("\\W+");
}
