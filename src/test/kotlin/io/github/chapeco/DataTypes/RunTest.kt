package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RunTest
{
    @Test
    fun instantiateRunTest()
    {
        val expectedRun = Run(

        )
        val actualRun = Run(

        )
        Assertions.assertEquals(expectedRun,actualRun)
    }

    @Test
    fun serializeRunTest()
    {
        val expectedRun: String = ""
        val actualRun = Result(

        )
        println(JSON.unquoted.stringify(actualRun))
        Assertions.assertEquals(expectedRun,JSON.unquoted.stringify(actualRun))
    }

    @Test
    fun deserializeRunTest()
    {
        val expectedRun = Run(

        )
        Assertions.assertEquals(expectedRun,JSON.unquoted.parse<Run>(""))
    }

    @Test
    fun getRunTest()
    {

    }

    @Test
    fun getRunsTest()
    {

    }

    @Test
    fun addRunTest()
    {

    }

    @Test
    fun updateRunTest()
    {

    }

    @Test
    fun closeRunTest()
    {

    }

    @Test
    fun deleteRunTest()
    {

    }
}