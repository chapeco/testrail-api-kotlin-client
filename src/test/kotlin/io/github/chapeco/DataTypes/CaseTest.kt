package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JSON
import kotlinx.serialization.serializer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CaseTest
{
    @Test
    fun instantiateCaseTest()
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
        Assertions.assertEquals(expectedCase,actualCase)
    }

    @Test
    fun serializeCaseTest()
    {
        val expectedCase: String = "{created_by:1,created_on:null,estimate_forecast:1s,id:1,section_id:1,suite_id:1,updated_by:1,updated_on:2000,title:\"My Expected Case\",template_id:1,type_id:1,priority_id:1,estimate:1s,milestone_id:1,refs:\"My Expected Reference\"}"
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
        Assertions.assertEquals(expectedCase,JSON.unquoted.stringify(actualCase))
    }

    @Test
    fun deserializeCaseTest()
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
        Assertions.assertEquals(expectedCase, JSON.unquoted.parse<Case>("{created_by:1,created_on:null,estimate_forecast:1s,id:1,section_id:1,suite_id:1,updated_by:1,updated_on:2000,title:\"My Expected Case\",template_id:1,type_id:1,priority_id:1,estimate:1s,milestone_id:1,refs:\"My Expected Reference\"}"))
    }

    @Test
    fun getCaseTest()
    {

    }

    @Test
    fun getCasesTest()
    {

    }

    @Test
    fun addCaseTest()
    {

    }

    @Test
    fun updateCaseTest()
    {

    }

    @Test
    fun deleteCaseTest()
    {

    }
}
