package com.todoist.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Utils {
    static boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static int clamp(int val, int min, int max) {
        return val < min ? min : (val > max ? max : val);
    }

    public static <T> Set<T> unmodifiableSet(Collection<? extends T> s) {
        if (s != null) {
            return Collections.unmodifiableSet(new HashSet<T>(s));
        } else {
            return Collections.emptySet();
        }
    }

    static <T> Set<T> unmodifiableSetWithElement(Set<? extends T> set, T el) {
        HashSet<T> copy = new HashSet<>(set.size() + 1);
        copy.addAll(set);
        copy.add(el);
        return Collections.unmodifiableSet(copy);
    }

    static <T> Set<T> unmodifiableSetWithoutElement(Set<? extends T> set, T el) {
        HashSet<T> copy = new HashSet<>(set.size() - 1);
        copy.addAll(set);
        copy.remove(el);
        return Collections.unmodifiableSet(copy);
    }
}
