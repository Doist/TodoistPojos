package com.todoist.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Utils {
    static boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static int clamp(int val, int min, int max) {
        return val < min ? min : (val > max ? max : val);
    }

    static <T> Set<T> unmodifiableSet(Collection<? extends T> set) {
        if (set != null) {
            return Collections.unmodifiableSet(new HashSet<T>(set));
        } else {
            // The empty set is immutable.
            return Collections.emptySet();
        }
    }

    static <T> List<T> unmodifiableList(Collection<? extends T> list) {
        if (list != null) {
            return Collections.unmodifiableList(new ArrayList<T>(list));
        } else {
            // The empty list is immutable.
            return Collections.emptyList();
        }
    }

    static <K, V> Map<K, V> unmodifiableMap(Map<K, V> map) {
        if (map != null) {
            return Collections.unmodifiableMap(new HashMap<>(map));
        } else {
            // The empty map is immutable.
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
