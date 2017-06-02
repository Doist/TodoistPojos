package com.todoist.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Utils {
    static boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static int clamp(int val, int min, int max) {
        return val < min ? min : (val > max ? max : val);
    }

    static <T> Set<T> unmodifiableSet(Collection<? extends T> s) {
        if (s != null) {
            return Collections.unmodifiableSet(new HashSet<T>(s));
        } else {
            // The empty set is immutable.
            return Collections.emptySet();
        }
    }

    static <K, V> Map<K, V> unmodifiableMap(Map<K, V> m) {
        if (m != null) {
            return Collections.unmodifiableMap(new LinkedHashMap<>(m));
        } else {
            // The empty set is immutable.
            return Collections.emptyMap();
        }
    }

    static <T> Set<T> unmodifiableSetWithElement(Set<? extends T> set, T el) {
        if (!set.isEmpty()) {
            HashSet<T> copy = new HashSet<>(set.size() + 1);
            copy.addAll(set);
            copy.add(el);
            return Collections.unmodifiableSet(copy);
        } else {
            // The singleton is immutable.
            return Collections.singleton(el);
        }
    }

    static <T> Set<T> unmodifiableSetWithoutElement(Set<? extends T> set, T el) {
        if (!set.isEmpty()) {
            HashSet<T> copy = new HashSet<>(set.size() - 1);
            copy.addAll(set);
            copy.remove(el);
            return Collections.unmodifiableSet(copy);
        } else {
            // The empty set is immutable.
            return Collections.emptySet();
        }
    }
}
