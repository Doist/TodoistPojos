package com.todoist.model;

import java.util.regex.Pattern;

public class Person extends TodoistObject {
    /* Matches leading and trailing spaces and special characters commonly found in name fields. */
    private static final Pattern ESCAPE_PATTERN = Pattern.compile("^\\s+|\\s+$|[\\(\\)\\.,\\-_\\[\\]'\"]");

    public static final int[] AVATAR_COLORS = {
            0xFFFCC652,
            0xFFE9952C,
            0xFFE16B2D,
            0xFFD84B40,
            0xFFE8435A,
            0xFFE5198A,
            0xFFAD3889,
            0xFF86389C,
            0xFFA8A8A8,
            0xFF98BE2F,
            0xFF5D9D50,
            0xFF5F9F85,
            0xFF5BBCB6,
            0xFF32A3BF,
            0xFF2BAFEB,
            0xFF2D88C3,
            0xFF3863CC,
            0xFF5E5E5E
    };

    private String email;
    private String fullName;
    private String imageId;

    public Person(long id, String email, String fullName, String imageId, boolean deleted) {
        super(id, deleted);
        this.email = email;
        this.fullName = fullName;
        this.imageId = imageId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public int getDefaultAvatarColorInt() {
        return getDefaultAvatarColorInt(email);
    }

    public String getDefaultAvatarText() {
        return getDefaultAvatarText(fullName);
    }

    public static int getDefaultAvatarColorInt(String email) {
        if (email != null) {
            int atIndex = email.indexOf("@");
            if (atIndex > 0) {
                return AVATAR_COLORS[(email.charAt(0) + email.charAt(atIndex - 1)) % AVATAR_COLORS.length];
            }
        }

        return 0xFF000000;
    }

    public static String getDefaultAvatarText(String fullName) {
        if (fullName != null) {
            String[] names = ESCAPE_PATTERN.matcher(fullName).replaceAll("").split("\\s+");

            if (names.length > 0) {
                StringBuilder initials = new StringBuilder(2);

                String firstName = names[0];
                if (firstName.length() > 0) {
                    initials.append(Character.toUpperCase(firstName.charAt(0)));
                }

                if (names.length > 1) {
                    String lastName = names[names.length - 1];
                    if (lastName.length() > 0) {
                        initials.append(Character.toUpperCase(lastName.charAt(0)));
                    }
                }

                if (initials.length() > 0) {
                    return initials.toString();
                }
            }
        }

        return "?";
    }
}
