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

    static <T> Set<T> unmodifiableSet(Collection<? extends T> s) {
        if (s != null) {
            return Collections.unmodifiableSet(new HashSet<T>(s));
        } else {
            // The empty set is immutable.
            return Collections.emptySet();
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

    static boolean contains(long[] array, long object) {
        for (long elem : array) {
            if (elem == object) {
                return true;
            }
        }

        return false;
    }

    static long[] add(long[] array1, long object) {
        long[] array = new long[array1.length + 1];

        System.arraycopy(array1, 0, array, 0, array1.length);
        array[array.length - 1] = object;

        return array;
    }

    static long[] remove(long[] array1, long object) {
        int index = -1;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == object) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            long[] array = new long[array1.length - 1];
            System.arraycopy(array1, 0, array, 0, index);
            if (index < array1.length - 1) {
                System.arraycopy(array1, index + 1, array, index, array1.length - index - 1);
            }
            return array;
        } else {
            return array1;
        }
    }
}
