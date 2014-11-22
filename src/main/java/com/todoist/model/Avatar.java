package com.todoist.model;

public enum Avatar {
    // In ascending order of size.
    SMALL(35, "small"),
    MEDIUM(60, "medium"),
    BIG(195, "big"),
    HUGE(480, "huge");

    private final int size;
    private final String arg;

    Avatar(int size, String arg) {
        this.size = size;
        this.arg = arg;
    }

    public String getUrl(String imageId) {
        if (imageId != null) {
            return "https://dcff1xvirvpfp.cloudfront.net/" + imageId + "_" + getForSize(size).arg + ".jpg";
        } else {
            return null;
        }
    }

    /**
     * Returns the first {@link Avatar} to be larger than {@code size}. If none exist, returns the largest one.
     */
    public static Avatar getForSize(int size) {
        Avatar[] avatars = values();
        for (int i = 0; i < avatars.length; i++) {
            Avatar avatar = avatars[i];
            if (avatar.size >= size || i == avatars.length - 1) {
                return avatar;
            }
        }
        return null; // Should never return this.
    }

    /**
     * Returns an array of {@link Avatar} ordered by how optimal they are. The first should be the best, followed by
     * larger sizes and finally the smaller ones.
     */
    public static Avatar[] getOrderedForSize(int size) {
        Avatar[] avatars = Avatar.values();
        Avatar[] result = new Avatar[avatars.length];

        result[0] = getForSize(size);
        int bestOrdinal = result[0].ordinal();

        for (int i = 1; i < result.length; i++) {
            int prevOrdinal = result[i - 1].ordinal();
            int ordinal;
            if (prevOrdinal >= bestOrdinal) {
                if (prevOrdinal < result.length - 1) {
                    ordinal = prevOrdinal + 1;
                } else {
                    ordinal = bestOrdinal - 1;
                }
            } else {
                ordinal = prevOrdinal - 1;
            }

            result[i] = avatars[ordinal];
        }

        return result;
    }
}
