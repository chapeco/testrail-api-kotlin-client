package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SuiteTest
{
    @Test
    fun instantiateSuiteTest()
    {
        val expectedSuite = Suite(

        )
        val actualSuite = Suite(

        )
        Assertions.assertEquals(expectedSuite,actualSuite)
    }

    @Test
    fun serializeSuiteTest()
    {
        val expectedSuite: String = ""
        val actualSuite = Suite(

        )
        println(JSON.unquoted.stringify(actualSuite))
        Assertions.assertEquals(expectedSuite,JSON.unquoted.stringify(actualSuite))
    }

    @Test
    fun deserializeSuiteTest()
    {
        val expectedSuite = Suite(

        )
        Assertions.assertEquals(expectedSuite,JSON.unquoted.parse<Suite>(""))
    }

    @Test
    fun getSuiteTest()
    {

    }

    @Test
    fun getSuitesTest()
    {

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