package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

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
        Assert.assertEquals(expectedTest,actualTest)
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
        Assert.assertEquals(expectedTest,JSON.unquoted.stringify(actualTest))
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
        Assert.assertEquals(expectedTest,JSON.unquoted.parse<TestObj>("{assignedto_id:1,case_id:1,id:1,milestone_id:1,priority_id:1,refs:\"some refs\",run_id:1,status_id:1,title:\"some title\",type_id:1,estimate:1s,estimate_forecast:1s}"))
    }

    @Test
    fun getTestTest()
    {
        val expectedTestObj = TestObj(
                caseId = 1,
                id = 1,
                priorityId = 2,
                runId = 1,
                statusId = 1,
                title = "Case_Foo",
                typeId = 7,
                templateId = 1,
                customAutomationType = "0"
        )
        val actualTestObj = TestObj().getTest(1)
        println(JSON.unquoted.stringify(actualTestObj))
        Assert.assertEquals(expectedTestObj,actualTestObj)
    }

    @Test
    fun getTestsTest()
    {
        val expectedTestObjList = listOf(
                TestObj(
                        caseId = 1,
                        id = 1,
                        priorityId = 2,
                        runId = 1,
                        statusId = 1,
                        title = "Case_Foo",
                        typeId = 7,
                        templateId = 1,
                        customAutomationType = "0"
                )
        )
        val actualTestObjList = TestObj().getTests(1)
        println(JSON.unquoted.stringify(TestObj.serializer().list,actualTestObjList))
        Assert.assertEquals(expectedTestObjList,actualTestObjList)
    }
}