package io.github.chapeco.DataTypes

import io.github.chapeco.DataTypes.SubTypes.Results
import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

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
        Assert.assertEquals(expectedResult,actualResult)
    }

    @Test
    fun serializeResultTest()
    {
        val expectedResult = "{status_id:1,comment:\"some comment\",version:\"some version\",defects:\"some defects\",custom_step_results:,created_on:1000,elapsed:1s,assignedto_id:1,created_by:1,id:1,test_id:1,case_id:}"
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
        println(JSON.unquoted.stringify(actualResult).replace(":\"null\"",":null"))
        Assert.assertEquals(expectedResult,JSON.unquoted.stringify(actualResult))
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
                assignedToId = 1,
                customStepResults = null
        )
        Assert.assertEquals(expectedResult,JSON.unquoted.parse<Result>("{test_id:1,status_id:1,comment:\"some comment\",version:\"some version\",defects:\"some defects\",custom_step_results:null,created_on:1000,elapsed:1s,assignedto_id:1,created_by:\"1\",id:1}"))
    }

    @Test
    fun getResultsTest()
    {
        val actualResultsList = Result().getResults(1)
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assert.assertTrue(actualResultsList.isNotEmpty())
    }

    @Test
    fun getResultsForCaseTest()
    {
        val actualResultsList = Result().getResultsForCase(1,1)
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assert.assertTrue(actualResultsList.isNotEmpty())
    }

    @Test
    fun getResultsForRunTest()
    {
        val actualResultsList = Result().getResultsForRun(1)
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assert.assertTrue(actualResultsList.isNotEmpty())
    }

    @Test
    fun addResultTest()
    {
        val expectedResult = Result(testId = 1, statusId = 1)
        val actualResult = expectedResult.addResult()
        println(JSON.unquoted.stringify(actualResult))
        Assert.assertEquals(expectedResult.testId,actualResult.testId)
    }

    @Test
    fun addResultForCaseTest()
    {
        val expectedResult = Result(caseId = 1, statusId = 1)
        val actualResult = expectedResult.addResultForCase(1)
        println(JSON.unquoted.stringify(actualResult))
        Assert.assertEquals(expectedResult.testId,actualResult.testId)
    }

    @Test
    fun addResultsTest()
    {
        val actualResultsList = Result().addResults(1, Results(listOf(Result(testId = 1, statusId = 1))))
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assert.assertTrue(actualResultsList.isNotEmpty())
    }

    @Test
    fun addResultsForCasesTest()
    {
        val actualResultsList = Result().addResultsForCases(1, Results(listOf(Result(caseId = 1, statusId = 1))))
        println(JSON.unquoted.stringify(Result.serializer().list,actualResultsList))
        Assert.assertTrue(actualResultsList.isNotEmpty())
    }
}