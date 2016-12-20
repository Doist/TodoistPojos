package com.todoist.pojo;

import java.util.Collection;
import java.util.Set;

public class Collaborator extends Person {
    public static final String STATE_ACTIVE = "active";
    public static final String STATE_INVITED = "invited";
    public static final String STATE_DELETED = "deleted";

    private Set<Long> projectsActive;
    private Set<Long> projectsInvited;

    public Collaborator(long id, String email, String fullName, String imageId,
                        Collection<Long> projectsActive, Collection<Long> projectsInvited, boolean deleted) {
        super(id, email, fullName, imageId, deleted);
        this.projectsActive = Utils.unmodifiableSet(projectsActive);
        this.projectsInvited = Utils.unmodifiableSet(projectsInvited);
    }

    public Collaborator(long id, String email, String fullName) {
        this(id, email, fullName, null, null, null, false);
    }

    public Collaborator(long id, String email) {
        this(id, email, null, null, null, null, false);
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
                projectsActive = Utils.unmodifiableSetWithElement(projectsActive, projectId);
                projectsInvited = Utils.unmodifiableSetWithoutElement(projectsInvited, projectId);
                break;

            case STATE_INVITED:
                projectsActive = Utils.unmodifiableSetWithoutElement(projectsActive, projectId);
                projectsInvited = Utils.unmodifiableSetWithElement(projectsInvited, projectId);
                break;

            case STATE_DELETED:
                projectsActive = Utils.unmodifiableSetWithoutElement(projectsActive, projectId);
                projectsInvited = Utils.unmodifiableSetWithoutElement(projectsInvited, projectId);
                break;

            default:
                throw new IllegalArgumentException("Unknown state.");
        }
    }

    /**
     * @return Unmodifiable set of active project ids.
     */
    public Set<Long> getProjectsActive() {
        return projectsActive;
    }

    /**
     * Copies the active project ids into an unmodifiable set.
     *
     * @see {@link #setProjectState(long, String)}
     */
    public void setProjectsActive(Collection<Long> projectsActive) {
        this.projectsActive = Utils.unmodifiableSet(projectsActive);
    }

    /**
     * @return Unmodifiable set of invited project ids.
     */
    public Set<Long> getProjectsInvited() {
        return projectsInvited;
    }

    /**
     * Copies the invited project ids into an unmodifiable set.
     *
     * @see {@link #setProjectState(long, String)}
     */
    public void setProjectsInvited(Collection<Long> projectsInvited) {
        this.projectsInvited = Utils.unmodifiableSet(projectsInvited);
    }
}
