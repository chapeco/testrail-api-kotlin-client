package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProjectTest
{
    @Test
    fun instantiateProjectTest()
    {
        val expectedProject = Project(

        )
        val actualProject = Project(

        )
        Assertions.assertEquals(expectedProject,actualProject)
    }

    @Test
    fun serializeProjectTest()
    {
        val expectedProject: String = ""
        val actualProject = Project(

        )
        println(JSON.unquoted.stringify(actualProject))
        Assertions.assertEquals(expectedProject,actualProject)
    }

    @Test
    fun deserializeProjectTest()
    {
        val expectedProject = Project(

        )
        Assertions.assertEquals(expectedProject,JSON.unquoted.parse<Project>(""))
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