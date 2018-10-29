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
        val expectedMilestone: String = "{id:1,milestones:[{id:null,milestones:null,project_id:null,url:null,name:null,description:null,parent_id:null,is_completed:null,is_started:null,completed_on:null,started_on:null,due_on:null,start_on:null}],project_id:1,url:\"some url\",name:\"some name\",description:\"some description\",parent_id:1,is_completed:false,is_started:true,completed_on:1000,started_on:500,due_on:2000,start_on:400}"
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
        Assertions.assertEquals(expectedMilestone.toString(),JSON.unquoted.parse<Milestone>("{id:1,milestones:[{id:null,milestones:null,project_id:null,url:null,name:null,description:null,parent_id:null,is_completed:null,is_started:null,completed_on:null,started_on:null,due_on:null,start_on:null}],project_id:1,url:\"some url\",name:\"some name\",description:\"some description\",parent_id:1,is_completed:false,is_started:true,completed_on:1000,started_on:500,due_on:2000,start_on:400}").toString())
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