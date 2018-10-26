package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MilestoneTest
{
    @Test
    fun instantiateMilestoneTest()
    {
        val expectedMilestone = Milestone(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                milestones = Array<Milestone>(1) { Milestone() },
                projectId = 1,
                startedOn = Timestamp(
                        time = 500
                ),
                url = "some url",
                name = "some name",
                description = "some description",
                dueOn = Timestamp(
                        time = 2000
                ),
                parentId = 1,
                startOn = Timestamp(
                        time = 400
                ),
                isCompleted = false,
                isStarted = true
        )
        val actualMilestone = Milestone(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                milestones = Array<Milestone>(1) { Milestone() },
                projectId = 1,
                startedOn = Timestamp(
                        time = 500
                ),
                url = "some url",
                name = "some name",
                description = "some description",
                dueOn = Timestamp(
                        time = 2000
                ),
                parentId = 1,
                startOn = Timestamp(
                        time = 400
                ),
                isCompleted = false,
                isStarted = true
        )
        Assertions.assertEquals(expectedMilestone,actualMilestone)
    }

    @Test
    fun serializeMilestoneTest()
    {
        val expectedMilestone: String = ""
        val actualMilestone = Milestone(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                milestones = Array<Milestone>(1) { Milestone() },
                projectId = 1,
                startedOn = Timestamp(
                        time = 500
                ),
                url = "some url",
                name = "some name",
                description = "some description",
                dueOn = Timestamp(
                        time = 2000
                ),
                parentId = 1,
                startOn = Timestamp(
                        time = 400
                ),
                isCompleted = false,
                isStarted = true
        )
        println(JSON.unquoted.stringify(actualMilestone))
        Assertions.assertEquals(expectedMilestone,JSON.unquoted.stringify(actualMilestone))
    }

    @Test
    fun deserializeMilestoneTest()
    {
        val expectedMilestone = Milestone(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                milestones = Array<Milestone>(1) { Milestone() },
                projectId = 1,
                startedOn = Timestamp(
                        time = 500
                ),
                url = "some url",
                name = "some name",
                description = "some description",
                dueOn = Timestamp(
                        time = 2000
                ),
                parentId = 1,
                startOn = Timestamp(
                        time = 400
                ),
                isCompleted = false,
                isStarted = true
        )
        Assertions.assertEquals(expectedMilestone,JSON.unquoted.parse<Milestone>(""))
    }

    @Test
    fun getMilestoneTest()
    {

    }

    @Test
    fun getMilestonesTest()
    {

    }

    @Test
    fun addMilestoneTest()
    {

    }

    @Test
    fun updateMilestoneTest()
    {

    }

    @Test
    fun deleteMilestoneTest()
    {

    }
}