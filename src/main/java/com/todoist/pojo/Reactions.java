package com.todoist.pojo;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Reactions {
    public static final String[] ORDER = {"👍", "👎", "❤️", "😄", "😂", "😮", "😢", "😡", "👏", "🎉"};

    private SortedMap<String, long[]> uids = new TreeMap<>(new ReactionsComparator());

    public Reactions(Map<String, long[]> uids) {
        setUids(uids);
    }

    public void setUids(Map<String, long[]> map) {
        uids.clear();
        if (map != null) {
            for (String key : map.keySet()) {
                uids.put(key, map.get(key));
            }
        }
    }

    public Map<String, long[]> getUids() {
        return new TreeMap<>(uids);
    }

    public boolean isEmpty() {
        return uids.isEmpty();
    }

    public boolean remove(String reaction, long id) {
        long[] reactionUids = uids.get(reaction);
        if (reactionUids != null && Utils.contains(reactionUids, id)) {
            uids.put(reaction, Utils.remove(reactionUids, id));
            return true;
        }

        return false;
    }

    public boolean add(String reaction, long id) {
        long[] reactionUids = uids.containsKey(reaction) ? uids.get(reaction) : new long[]{};
        if (!Utils.contains(reactionUids, id)) {
            uids.put(reaction, Utils.add(reactionUids, id));
            return true;
        }

        return false;
    }

    public static class ReactionsComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1 != null && s1.equals(s2)) {
                return 0;
            }

            for (String reaction : ORDER) {
                if (reaction.equals(s1)) {
                    return -1;
                } else if (reaction.equals(s2)) {
                    return 1;
                }
            }

            return 0;
        }
    }
}
