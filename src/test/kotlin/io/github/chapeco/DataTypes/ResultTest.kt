package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ResultTest
{
    @Test
    fun instantiateResultTest()
    {
        val expectedResult = Result(
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                testId = 1,
                statusId = 1,
                comment = "some comment",
                version = "some version",
                elapsed = Timespan(
                        seconds = 1
                ),
                defects = "some defects",
                assignedToId = 1
        )
        val actualResult = Result(
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                testId = 1,
                statusId = 1,
                comment = "some comment",
                version = "some version",
                elapsed = Timespan(
                        seconds = 1
                ),
                defects = "some defects",
                assignedToId = 1
        )
        Assertions.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun serializeResultTest()
    {
        val expectedResult: String = ""
        val actualResult = Result(
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                testId = 1,
                statusId = 1,
                comment = "some comment",
                version = "some version",
                elapsed = Timespan(
                        seconds = 1
                ),
                defects = "some defects",
                assignedToId = 1
        )
        println(JSON.unquoted.stringify(actualResult))
        Assertions.assertEquals(expectedResult,JSON.unquoted.stringify(actualResult))
    }

    @Test
    fun deserializeResultTest()
    {
        val expectedResult = Result(
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                id = 1,
                testId = 1,
                statusId = 1,
                comment = "some comment",
                version = "some version",
                elapsed = Timespan(
                        seconds = 1
                ),
                defects = "some defects",
                assignedToId = 1
        )
        Assertions.assertEquals(expectedResult,JSON.unquoted.parse<Result>(""))
    }

    @Test
    fun getResultsTest()
    {

    }

    @Test
    fun getResultsForCaseTest()
    {

    }

    @Test
    fun getResultsForRunTest()
    {

    }

    @Test
    fun addResultTest()
    {

    }

    @Test
    fun addResultForCaseTest()
    {

    }

    @Test
    fun addResultsTest()
    {

    }

    @Test
    fun addResultsForCasesTest()
    {

    }
}