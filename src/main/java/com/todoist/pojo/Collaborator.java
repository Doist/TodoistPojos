package com.todoist.pojo;

import java.util.Collection;
import java.util.HashSet;

public class Collaborator extends Person {
    public static final String STATE_ACTIVE = "active";
    public static final String STATE_INVITED = "invited";
    public static final String STATE_DELETED = "deleted";

    private Collection<Long> projectsActive = new HashSet<>();
    private Collection<Long> projectsInvited = new HashSet<>();

    public Collaborator(long id, String email, String fullName, String imageId,
                        Collection<Long> projectsActive, Collection<Long> projectsInvited, boolean deleted) {
        super(id, email, fullName, imageId, deleted);
        if (projectsActive != null) {
            this.projectsActive.addAll(projectsActive);
        }
        if (projectsInvited != null) {
            this.projectsInvited.addAll(projectsInvited);
        }
    }

    public Collaborator(long id, String email, String fullName) {
        super(id, email, fullName, null, false);
    }

    public Collaborator(long id, String email) {
        super(id, email, null, null, false);
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
}
