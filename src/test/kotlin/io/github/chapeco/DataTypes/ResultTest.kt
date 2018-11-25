package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
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
        val expectedResult: String = "{created_by:1,id:1,test_id:1,status_id:1,comment:\"some comment\",version:\"some version\",defects:\"some defects\",assignedto_id:1,created_on:1000,elapsed:1s}"
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
        Assertions.assertEquals(expectedResult,JSON.unquoted.parse<Result>("{created_by:1,id:1,test_id:1,status_id:1,comment:\"some comment\",version:\"some version\",defects:\"some defects\",assignedto_id:1,created_on:1000,elapsed:1s}"))
    }

    @Test
    fun getResultsTest()
    {
        val expectedResultsList = listOf(
                Result(
                        createdBy = 1,
                        id = 1,
                        testId = 1,
                        statusId = 1,
                        createdOn = Timestamp(1542143242)
                )
        )
        val actualResultsList = Result().getResults(1)
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assertions.assertEquals(expectedResultsList,actualResultsList)
    }

    @Test
    fun getResultsForCaseTest()
    {
        val expectedResultsList = listOf(
                Result(
                        createdBy = 1,
                        id = 1,
                        testId = 1,
                        statusId = 1,
                        createdOn = Timestamp(1542143242)
                )
        )
        val actualResultsList = Result().getResultsForCase(1,1)
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assertions.assertEquals(expectedResultsList,actualResultsList)
    }

    @Test
    fun getResultsForRunTest()
    {
        val expectedResultsList = listOf(
                Result(
                        createdBy = 1,
                        id = 1,
                        testId = 1,
                        statusId = 1,
                        createdOn = Timestamp(1542143242)
                )
        )
        val actualResultsList = Result().getResultsForRun(1)
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assertions.assertEquals(expectedResultsList,actualResultsList)
    }

    @Test
    fun addResultTest()
    {
        val expectedResult = Result(testId = 1)
        val actualResult = Result().addResult(expectedResult)
        Assertions.assertEquals(expectedResult,actualResult)
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