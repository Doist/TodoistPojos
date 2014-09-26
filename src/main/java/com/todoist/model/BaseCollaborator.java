package com.todoist.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Pattern;

public class BaseCollaborator extends TodoistObjectWithId {
    /* Matches leading and trailing spaces and special characters commonly found in name fields. */
    private static final Pattern ESCAPE_PATTERN = Pattern.compile("^\\s+|\\s+$|[\\(\\)\\.,\\-_\\[\\]'\"]");

    public static final String STATE_ACTIVE = "active";
    public static final String STATE_INVITED = "invited";
    public static final String STATE_DELETED = "deleted";

    public static final int AVATAR_BIG_SIZE = 195;
    public static final int AVATAR_MEDIUM_SIZE = 60;
    public static final int AVATAR_SMALL_SIZE = 35;

    public static final String[] AVATAR_COLORS = Colors.COLLABORATOR_AVATAR_COLORS;

    private String fullName;
    private String email;
    private String avatarBig;
    private String avatarMedium;
    private String avatarSmall;
    private Collection<Long> projectsActive = new HashSet<>();
    private Collection<Long> projectsInvited = new HashSet<>();

    public BaseCollaborator(long id, String fullName, String email, String avatarBig,
                            String avatarMedium, String avatarSmall, Collection<Long> projectsActive,
                            Collection<Long> projectsInvited, boolean deleted) {
        super(id, deleted);
        this.fullName = fullName;
        this.email = email;
        this.avatarBig = avatarBig;
        this.avatarMedium = avatarMedium;
        this.avatarSmall = avatarSmall;
        if (projectsActive != null) {
            this.projectsActive.addAll(projectsActive);
        }
        if (projectsInvited != null) {
            this.projectsInvited.addAll(projectsInvited);
        }
    }

    public BaseCollaborator(long id, String fullName, String email) {
        super(id, false);
        this.fullName = fullName;
        this.email = email;
    }

    public BaseCollaborator(long id, String email) {
        super(id, false);
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarBig() {
        return avatarBig;
    }

    public void setAvatarBig(String avatarBig) {
        this.avatarBig = avatarBig;
    }

    public String getAvatarMedium() {
        return avatarMedium;
    }

    public void setAvatarMedium(String avatarMedium) {
        this.avatarMedium = avatarMedium;
    }

    public String getAvatarSmall() {
        return avatarSmall;
    }

    public void setAvatarSmall(String avatarSmall) {
        this.avatarSmall = avatarSmall;
    }

    public Collection<Long> getProjectsActive() {
        return projectsActive;
    }

    public String getProjectState(long projectId) {
        if (projectsActive.contains(projectId)) {
            return STATE_ACTIVE;
        }
        if (projectsInvited.contains(projectId)) {
            return STATE_INVITED;
        }
        return STATE_DELETED;
    }

    /**
     * Sets the state for a specific project id.
     */
    public void setProjectState(long projectId, String state) {
        switch (state) {
            case STATE_ACTIVE:
                projectsActive.add(projectId);
                projectsInvited.remove(projectId);
                break;

            case STATE_INVITED:
                projectsActive.remove(projectId);
                projectsInvited.add(projectId);
                break;

            case STATE_DELETED:
                projectsActive.remove(projectId);
                projectsInvited.remove(projectId);
                break;

            default:
                throw new IllegalArgumentException("Unknown state.");
        }
    }

    /**
     * Sets the active projects. The internal collection is cleared and copies the elements in {@code projectsActive},
     * if any.
     *
     * @see {@link #setProjectState(long, String)}
     */
    public void setProjectsActive(Collection<Long> projectsActive) {
        this.projectsActive.clear();
        if (projectsActive != null) {
            this.projectsActive.addAll(projectsActive);
        }
    }

    public Collection<Long> getProjectsInvited() {
        return projectsInvited;
    }

    /**
     * Sets the invited projects. The internal collection is cleared and copies the elements in {@code projectsInvited},
     * if any.
     *
     * @see {@link #setProjectState(long, String)}
     */
    public void setProjectsInvited(Collection<Long> projectsInvited) {
        this.projectsInvited.clear();
        if (projectsInvited != null) {
            this.projectsInvited.addAll(projectsInvited);
        }
    }

    public String getDefaultAvatarColor() {
        return getDefaultAvatarColor(email);
    }

    public String getDefaultAvatarText() {
        return getDefaultAvatarText(fullName);
    }

    public static String getDefaultAvatarColor(String email) {
        if (email != null) {
            int atIndex = email.indexOf("@");
            if (atIndex > 0) {
                return AVATAR_COLORS[(email.charAt(0) + email.charAt(atIndex - 1)) % AVATAR_COLORS.length];
            }
        }

        return "#000000";
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
