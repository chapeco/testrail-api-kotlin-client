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
        val expectedTest: String = "{assignedto_id:1,case_id:1,id:1,milestone_id:1,priority_id:1,refs:\"some refs\",run_id:1,status_id:1,title:\"some title\",type_id:1,estimate:1s,estimate_forecast:1s}"
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
        Assertions.assertEquals(expectedTest,JSON.unquoted.parse<TestObj>("{assignedto_id:1,case_id:1,id:1,milestone_id:1,priority_id:1,refs:\"some refs\",run_id:1,status_id:1,title:\"some title\",type_id:1,estimate:1s,estimate_forecast:1s}"))
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