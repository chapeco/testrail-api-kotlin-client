package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import kotlinx.serialization.serializer
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CaseTest
{
    var deleteCaseId: Int? = 0

    @Test
    fun a_InstantiateCaseTest()
    {
        val expectedCase = Case(
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                sectionId = 1,
                suiteId = 1,
                updatedBy = 1,
                updatedOn = Timestamp(
                        time = 2000
                ),
                title = "My Expected Case",
                templateId = 1,
                typeId = 1,
                priorityId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                milestoneId = 1,
                refs = "My Expected Reference"
        )
        val actualCase = Case(
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                sectionId = 1,
                suiteId = 1,
                updatedBy = 1,
                updatedOn = Timestamp(
                        time = 2000
                ),
                title = "My Expected Case",
                templateId = 1,
                typeId = 1,
                priorityId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                milestoneId = 1,
                refs = "My Expected Reference"
        )
        Assert.assertEquals(expectedCase,actualCase)
    }

    @Test
    fun b_SerializeCaseTest()
    {
        val expectedCase: String = "{created_by:1,id:1,section_id:1,suite_id:1,updated_by:1,title:\"My Expected Case\",template_id:1,type_id:1,priority_id:1,milestone_id:1,refs:\"My Expected Reference\",custom_automation_type:null,custom_expected:null,custom_preconds:null,custom_steps:null,custom_steps_separated:null,custom_mission:null,custom_goals:null,created_on:null,updated_on:2000,estimate_forecast:1s,estimate:1s}"
        val actualCase = Case(
                createdBy = 1,
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                sectionId = 1,
                suiteId = 1,
                updatedBy = 1,
                updatedOn = Timestamp(
                        time = 2000
                ),
                title = "My Expected Case",
                templateId = 1,
                typeId = 1,
                priorityId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                milestoneId = 1,
                refs = "My Expected Reference"
        )
        println(JSON.unquoted.stringify(actualCase))
        Assert.assertEquals(expectedCase,JSON.unquoted.stringify(actualCase))
    }

    @Test
    fun c_DeserializeCaseTest()
    {
        val expectedCase = Case(
                createdBy = 1,
                estimateForecast = Timespan(
                        seconds = 1
                ),
                id = 1,
                sectionId = 1,
                suiteId = 1,
                updatedBy = 1,
                updatedOn = Timestamp(
                        time = 2000
                ),
                title = "My Expected Case",
                templateId = 1,
                typeId = 1,
                priorityId = 1,
                estimate = Timespan(
                        seconds = 1
                ),
                milestoneId = 1,
                refs = "My Expected Reference"
        )
        Assert.assertEquals(expectedCase,JSON.unquoted.parse<Case>("{created_by:1,created_on:null,estimate_forecast:1s,id:1,section_id:1,suite_id:1,updated_by:1,updated_on:2000,title:\"My Expected Case\",template_id:1,type_id:1,priority_id:1,estimate:1s,milestone_id:1,refs:\"My Expected Reference\"}"))
    }

    @Test
    fun d_GetCaseTest()
    {
            val expectedCase = Case(
                    createdBy=1,
                    createdOn=Timestamp(1542142832),
                    id=1,
                    sectionId=1,
                    suiteId=1,
                    updatedBy=1,
                    updatedOn=Timestamp(1542142832),
                    title="Case_Foo",
                    templateId=1,
                    typeId=7,
                    priorityId=2,
                    automationType="0"
            )
            val actualCase = Case().getCase(1)
            println(actualCase)
            Assert.assertEquals(expectedCase,actualCase)
    }

    @Test
    fun e_GetCasesTest()
    {
            val actualCaseList = Case().getCases(1,suiteId = 1)
            println(JSON.unquoted.stringify(Case.serializer().list,actualCaseList))
            Assert.assertTrue(actualCaseList.isNotEmpty())
    }

    @Test
    fun f_AddCaseTest()
    {
            val expectedCase = Case(
                    sectionId = 1,
                    title = "My Expected Case"
            )
            val actualCase = expectedCase.addCase()
            println(actualCase.id)
            System.setProperty("updateCaseJSON", JSON.stringify(actualCase))
            System.setProperty("deleteCaseId", actualCase.id.toString())
            println(JSON.unquoted.stringify(actualCase))
            Assert.assertEquals(expectedCase.title,actualCase.title)
    }

    @Test
    fun g_UpdateCaseTest()
    {
            val expectedCase = JSON.parse<Case>(System.getProperty("updateCaseJSON"))
            val actualCase = Case().updateCase()
            println(JSON.unquoted.stringify(actualCase))
            Assert.assertEquals(expectedCase.title,actualCase.title)
    }

    @Test
    fun h_DeleteCaseTest()
    {
            val deletedCase = deleteCaseId
            Case().deleteCase()
            val expectedCase = false
            val actualCase = Case().getCases(1,1)
            println(JSON.unquoted.stringify(Case.serializer().list,actualCase))
            Assert.assertEquals(expectedCase,JSON.unquoted.stringify(Case.serializer().list,actualCase).contains("id:$deletedCase"))
    }
}
