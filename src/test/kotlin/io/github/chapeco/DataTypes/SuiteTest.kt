package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SuiteTest
{
    @Test
    fun instantiateSuiteTest()
    {
        val expectedSuite = Suite(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                isBaseline = true,
                isCompleted = false,
                isMaster = true,
                projectId = 1,
                url = "some url",
                name = "some name",
                description = "some description"
        )
        val actualSuite = Suite(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                isBaseline = true,
                isCompleted = false,
                isMaster = true,
                projectId = 1,
                url = "some url",
                name = "some name",
                description = "some description"
        )
        Assertions.assertEquals(expectedSuite,actualSuite)
    }

    @Test
    fun serializeSuiteTest()
    {
        val expectedSuite: String = "{id:1,is_baseline:true,is_completed:false,is_master:true,project_id:1,url:\"some url\",name:\"some name\",description:\"some description\",completed_on:1000}"
        val actualSuite = Suite(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                isBaseline = true,
                isCompleted = false,
                isMaster = true,
                projectId = 1,
                url = "some url",
                name = "some name",
                description = "some description"
        )
        println(JSON.unquoted.stringify(actualSuite))
        Assertions.assertEquals(expectedSuite,JSON.unquoted.stringify(actualSuite))
    }

    @Test
    fun deserializeSuiteTest()
    {
        val expectedSuite = Suite(
                completedOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                isBaseline = true,
                isCompleted = false,
                isMaster = true,
                projectId = 1,
                url = "some url",
                name = "some name",
                description = "some description"
        )
        Assertions.assertEquals(expectedSuite,JSON.unquoted.parse<Suite>("{id:1,is_baseline:true,is_completed:false,is_master:true,project_id:1,url:\"some url\",name:\"some name\",description:\"some description\",completed_on:1000}"))
    }

    @Test
    fun getSuiteTest()
    {
        val expectedSuite = Suite(
                id = 1,
                isBaseline = false,
                isCompleted = false,
                isMaster = false,
                projectId = 1,
                url = "https://techdemo4.testrail.io/index.php?/suites/view/1",
                name = "API_Test_Suite"
        )
        val actualSuite = Suite().getSuite(1)
        println(JSON.unquoted.stringify(actualSuite))
        Assertions.assertEquals(expectedSuite,actualSuite)
    }

    @Test
    fun getSuitesTest()
    {
        val expectedSuitesList = listOf(
                Suite(
                        id = 1,
                        isBaseline = false,
                        isCompleted = false,
                        isMaster = false,
                        projectId = 1,
                        url = "https://techdemo4.testrail.io/index.php?/suites/view/1",
                        name = "API_Test_Suite"
                )
        )
        val actualSuitesList = Suite().getSuites(1)
        println(JSON.unquoted.stringify(Suite.serializer().list,actualSuitesList))
        Assertions.assertEquals(expectedSuitesList,actualSuitesList)
    }

    @Test
    fun addSuiteTest()
    {

    }

    @Test
    fun updateSuiteTest()
    {

    }

    @Test
    fun deleteSuiteTest()
    {

    }
}