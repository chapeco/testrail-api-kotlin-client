package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestTest
{
    @Test
    fun instantiateTestTest()
    {
        val expectedTest = TestObj(
                assignedToId = 1,
                caseId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                milestoneId = 1,
                priorityId = 1,
                refs = "some refs",
                runId = 1,
                statusId = 1,
                title = "some title",
                typeId = 1
        )
        val actualTest = TestObj(
                assignedToId = 1,
                caseId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                milestoneId = 1,
                priorityId = 1,
                refs = "some refs",
                runId = 1,
                statusId = 1,
                title = "some title",
                typeId = 1
        )
        Assertions.assertEquals(expectedTest,actualTest)
    }

    @Test
    fun serializeTestTest()
    {
        val expectedTest: String = ""
        val actualTest = TestObj(
                assignedToId = 1,
                caseId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                milestoneId = 1,
                priorityId = 1,
                refs = "some refs",
                runId = 1,
                statusId = 1,
                title = "some title",
                typeId = 1
        )
        println(JSON.unquoted.stringify(actualTest))
        Assertions.assertEquals(expectedTest,JSON.unquoted.stringify(actualTest))
    }

    @Test
    fun deserializeTestTest()
    {
        val expectedTest = TestObj(
                assignedToId = 1,
                caseId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                milestoneId = 1,
                priorityId = 1,
                refs = "some refs",
                runId = 1,
                statusId = 1,
                title = "some title",
                typeId = 1
        )
        Assertions.assertEquals(expectedTest,JSON.unquoted.parse<TestObj>(""))
    }

    @Test
    fun getTestTest()
    {

    }

    @Test
    fun getTestsTest()
    {

    }
}