package com.todoist.pojo;

class Utils {
    static boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static int clamp(int val, int min, int max) {
        return val < min ? min : (val > max ? max : val);
    }
}
