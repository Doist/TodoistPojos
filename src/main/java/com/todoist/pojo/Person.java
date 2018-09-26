package com.todoist.pojo;

import java.util.regex.Pattern;

public class Person extends TodoistObject {
    /* Matches leading and trailing spaces and special characters commonly found in name fields. */
    private static final Pattern ESCAPE_PATTERN = Pattern.compile("^\\s+|\\s+$|[\\(\\)\\.,\\-_\\[\\]'\"]");

    private static final int[] LIGHT_AVATAR_COLORS = {
            0XFFE9952C,
            0XFFE16B2D,
            0XFFD84B40,
            0XFFE8435A,
            0XFFE5198A,
            0XFFAD3889,
            0XFF86389C,
            0XFF98BE2F,
            0XFF5D9D50,
            0XFF5F9F85,
            0XFF5BBCB6,
            0XFF32A3BF,
            0XFF2BAFEB,
            0XFF2D88C3,
            0XFF3863CC,
            0XFF5E5E5E
    };

    private static final int[] DARK_AVATAR_COLORS = {
            0XFFFCC652,
            0XFFE9952C,
            0XFFE16B2D,
            0XFFD84B40,
            0XFFE8435A,
            0XFFE5198A,
            0XFFAD3889,
            0XFFA8A8A8,
            0XFF98BE2F,
            0XFF5D9D50,
            0XFF5F9F85,
            0XFF5BBCB6,
            0XFF32A3BF,
            0XFF2BAFEB,
            0XFF2D88C3
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

    public int getDefaultAvatarColorInt(boolean useLightColors) {
        return getDefaultAvatarColorInt(email, useLightColors);
    }

    public String getDefaultAvatarText() {
        return getDefaultAvatarText(fullName);
    }

    public static int getDefaultAvatarColorInt(String email, boolean useLightColors) {
        if (email != null) {
            int atIndex = email.indexOf("@");
            if (atIndex > 0) {
                int[] colors = getAvatarColors(useLightColors);
                return colors[(email.charAt(0) + email.charAt(atIndex - 1)) % colors.length];
            }
        }

        return 0xFF000000;
    }

    private static int[] getAvatarColors(boolean useLightColors) {
        return useLightColors ? LIGHT_AVATAR_COLORS : DARK_AVATAR_COLORS;
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
