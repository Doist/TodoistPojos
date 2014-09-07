package com.todoist.model;

import java.util.Collection;
import java.util.HashSet;

public class BaseCollaborator extends TodoistObjectWithId {
    public static final String STATE_ACTIVE = "active";
    public static final String STATE_INVITED = "invited";
    public static final String STATE_DELETED = "deleted";

    public static final int AVATAR_BIG_SIZE = 195;
    public static final int AVATAR_MEDIUM_SIZE = 60;
    public static final int AVATAR_SMALL_SIZE = 35;

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
}
