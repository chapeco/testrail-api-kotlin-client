package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProjectTest
{
    @Test
    fun instantiateProjectTest()
    {
        val expectedProject = Project(
                id = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                url = "some url",
                name = "some name",
                announcement = "some announcement",
                showAnnouncement = true,
                suiteMode = 1,
                isCompleted = false
        )
        val actualProject = Project(
                id = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                url = "some url",
                name = "some name",
                announcement = "some announcement",
                showAnnouncement = true,
                suiteMode = 1,
                isCompleted = false
        )
        Assertions.assertEquals(expectedProject,actualProject)
    }

    @Test
    fun serializeProjectTest()
    {
        val expectedProject: String = "{id:1,url:\"some url\",name:\"some name\",announcement:\"some announcement\",show_announcement:true,suite_mode:1,is_completed:false,completed_on:1000}"
        val actualProject = Project(
                id = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                url = "some url",
                name = "some name",
                announcement = "some announcement",
                showAnnouncement = true,
                suiteMode = 1,
                isCompleted = false
        )
        println(JSON.unquoted.stringify(actualProject))
        Assertions.assertEquals(expectedProject,JSON.unquoted.stringify(actualProject))
    }

    @Test
    fun deserializeProjectTest()
    {
        val expectedProject = Project(
                id = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                url = "some url",
                name = "some name",
                announcement = "some announcement",
                showAnnouncement = true,
                suiteMode = 1,
                isCompleted = false
        )
        Assertions.assertEquals(expectedProject,JSON.unquoted.parse<Project>("{id:1,url:\"some url\",name:\"some name\",announcement:\"some announcement\",show_announcement:true,suite_mode:1,is_completed:false,completed_on:1000}"))
    }

    @Test
    fun getProjectTest()
    {

    }

    @Test
    fun getProjectsTest()
    {

    }

    @Test
    fun addProjectTest()
    {

    }

    @Test
    fun updateProjectTest()
    {

    }

    @Test
    fun deleteProjectTest()
    {

    }
}