package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.Assert
import org.junit.Test

class PlanEntryTest
{
    @Test
    fun instantiatePlanEntryTest()
    {
        val expectedPlanEntry = PlanEntry(
                suiteId = 1,
                configIds = listOf(1),
                runs = listOf(Run()),
                name = "some name",
                description = "some description",
                assignedToId = 1,
                includeAll = true,
                caseIds = listOf(1)
        )
        val actualPlanEntry = PlanEntry(
                suiteId = 1,
                configIds = listOf(1),
                runs = listOf(Run()),
                name = "some name",
                description = "some description",
                assignedToId = 1,
                includeAll = true,
                caseIds = listOf(1)
        )
        Assert.assertEquals(expectedPlanEntry.toString(),actualPlanEntry.toString())
    }

    @Test
    fun serializePlanEntryTest()
    {
        val expectedPlanEntry: String = "{suite_id:1,config_ids:[1],runs:[{blocked_count:null,config:null,config_ids:null,created_by:null,custom_status?_count:null,failed_count:null,id:null,is_completed:null,plan_id:null,passed_count:null,project_id:null,retest_count:null,untested_count:null,url:null,suite_id:null,assignedto_id:null,name:null,description:null,milestone_id:null,include_all:null,case_ids:null,completed_on:null,created_on:null}],name:\"some name\",description:\"some description\",assignedto_id:1,include_all:true,case_ids:[1]}"
        val actualPlanEntry = PlanEntry(
                suiteId = 1,
                configIds = listOf(1),
                runs = listOf(Run()),
                name = "some name",
                description = "some description",
                assignedToId = 1,
                includeAll = true,
                caseIds = listOf(1)
        )
        println(JSON.unquoted.stringify(actualPlanEntry))
        Assert.assertEquals(expectedPlanEntry,JSON.unquoted.stringify(actualPlanEntry))
    }

    @Test
    fun deserializePlanEntryTest()
    {
        val expectedPlanEntry = PlanEntry(
                suiteId = 1,
                configIds = listOf(1),
                runs = listOf(Run()),
                name = "some name",
                description = "some description",
                assignedToId = 1,
                includeAll = true,
                caseIds = listOf(1)
        )
        Assert.assertEquals(expectedPlanEntry.toString(),JSON.unquoted.parse<PlanEntry>("{suite_id:1,config_ids:[1],runs:[{blocked_count:null,config:null,config_ids:null,created_by:null,custom_status?_count:null,failed_count:null,id:null,is_completed:null,plan_id:null,passed_count:null,project_id:null,retest_count:null,untested_count:null,url:null,suite_id:null,assignedto_id:null,name:null,description:null,milestone_id:null,include_all:null,case_ids:null,completed_on:null,created_on:null}],name:\"some name\",description:\"some description\",assignedto_id:1,include_all:true,case_ids:[1]}").toString())
    }

    @Test
    fun addPlanEntryTest()
    {
        val expectedPlanEntry = PlanEntry(name = "API TEST PlanEntry", planId = 1)
        val actualPlanEntry = expectedPlanEntry.addPlanEntry()
        println(JSON.unquoted.stringify(actualPlanEntry))
        Assert.assertEquals(expectedPlanEntry.name,actualPlanEntry.name)
    }

    @Test
    fun updatePlanEntryTest()
    {
        val expectedUpdatedPlanEntry = PlanEntry(name = "API TEST Updated PlanEntry", planId = 1, id = "")
        val actualUpdatedPlanEntry = expectedUpdatedPlanEntry.updatePlanEntry()
        println(JSON.unquoted.stringify(actualUpdatedPlanEntry))
        Assert.assertEquals(expectedUpdatedPlanEntry.name,actualUpdatedPlanEntry.name)
    }

    @Test
    fun deletePlanEntryTest()
    {
        val expectedDeletedPlanEntry = PlanEntry(planId = 1, id = "")
        expectedDeletedPlanEntry.deletePlanEntry()
    }
}