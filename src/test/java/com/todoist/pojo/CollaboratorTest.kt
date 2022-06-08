package com.todoist.pojo

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CollaboratorTest {
    @Test
    fun setProjectState() {
        val projectId = 22L

        Collaborator(ID, EMAIL).apply {
            setProjectState(projectId, Collaborator.STATE_INVITED)
            assertEquals(true, projectsInvited.contains(projectId))
            assertEquals(false, projectsActive.contains(projectId))

            setProjectState(projectId, Collaborator.STATE_ACTIVE)
            assertEquals(false, projectsInvited.contains(projectId))
            assertEquals(true, projectsActive.contains(projectId))

            setProjectState(projectId, Collaborator.STATE_DELETED)
            assertEquals(false, projectsInvited.contains(projectId))
            assertEquals(false, projectsActive.contains(projectId))
        }

        Collaborator(ID, EMAIL).apply {
            assertFailsWith<IllegalArgumentException> {
                setProjectState(projectId, "bogus")
            }
        }
    }

    @Test
    fun getProjectState() {
        val projectId = 22L

        Collaborator(ID, EMAIL).apply {
            assertEquals(Collaborator.STATE_DELETED, getProjectState(projectId))
        }

        Collaborator(ID, EMAIL).apply {
            projectsInvited = setOf(projectId)
            assertEquals(Collaborator.STATE_INVITED, getProjectState(projectId))
        }

        Collaborator(ID, EMAIL).apply {
            projectsActive = setOf(projectId)
            assertEquals(Collaborator.STATE_ACTIVE, getProjectState(projectId))
        }

        Collaborator(ID, EMAIL).apply {
            projectsInvited = setOf(projectId)
            projectsActive = setOf(projectId)
            assertEquals(Collaborator.STATE_ACTIVE, getProjectState(projectId))
        }
    }

    companion object {
        const val ID = 10L
        const val EMAIL = "test@doist.com"
    }
}
