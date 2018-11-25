package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
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
        val expectedProject = JSON.unquoted.parse<Project>("{\"id\":1,\"name\":\"API_Test_Project\",\"announcement\":null,\"show_announcement\":false,\"is_completed\":false,\"completed_on\":null,\"suite_mode\":3,\"url\":\"https:\\/\\/techdemo4.testrail.io\\/index.php?\\/projects\\/overview\\/1\"}")
        val actualProject = Project().getProject(1)
        Assertions.assertEquals(expectedProject,actualProject)
    }

    @Test
    fun getProjectsTest()
    {
        val expectedProjectsList = listOf(
                Project(
                        id = 1,
                        url = "https://techdemo4.testrail.io/index.php?/projects/overview/1",
                        name = "API_Test_Project",
                        showAnnouncement = false,
                        suiteMode = 3,
                        isCompleted = false
                )
        )
        val actualProjectsList = Project().getProjects()
        println(JSON.unquoted.stringify(Project.serializer().list,actualProjectsList))
        Assertions.assertEquals(expectedProjectsList,actualProjectsList)
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