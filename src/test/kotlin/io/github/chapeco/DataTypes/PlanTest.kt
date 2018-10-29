package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlanTest
{
    @Test
    fun instantiatePlanTest()
    {
        val expectedPlan = Plan(
                assignedToId = 1,
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                failedCount = 1,
                isCompleted = false,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                name = "some name",
                description = "some description",
                milestoneId = 1,
                entries = Array<PlanEntry>(1) { PlanEntry() }

        )
        val actualPlan = Plan(
                assignedToId = 1,
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                failedCount = 1,
                isCompleted = false,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                name = "some name",
                description = "some description",
                milestoneId = 1,
                entries = Array<PlanEntry>(1) {PlanEntry()}
        )
        Assertions.assertEquals(expectedPlan.toString(),actualPlan.toString())
    }

    @Test
    fun serializePlanTest()
    {
        val expectedPlan: String = "{assignedto_id:1,blocked_count:1,created_by:1,custom_status?_count:null,failed_count:1,id:null,is_completed:false,passed_count:1,project_id:1,retest_count:1,untested_count:1,url:\"some url\",name:\"some name\",description:\"some description\",milestone_id:1,entries:[{suite_id:null,config_ids:null,runs:null,name:null,description:null,assignedto_id:null,include_all:null,case_ids:null}],completed_on:1000,created_on:1000}"
        val actualPlan = Plan(
                assignedToId = 1,
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                failedCount = 1,
                isCompleted = false,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                name = "some name",
                description = "some description",
                milestoneId = 1,
                entries = Array<PlanEntry>(1) {PlanEntry()}
        )
        println(JSON.unquoted.stringify(actualPlan))
        Assertions.assertEquals(expectedPlan,JSON.unquoted.stringify(actualPlan))
    }

    @Test
    fun deserializePlanTest()
    {
        val expectedPlan = Plan(
                assignedToId = 1,
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                failedCount = 1,
                isCompleted = false,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                name = "some name",
                description = "some description",
                milestoneId = 1,
                entries = Array<PlanEntry>(1) {PlanEntry()}
        )
        Assertions.assertEquals(expectedPlan.toString(),JSON.unquoted.parse<Plan>("{assignedto_id:1,blocked_count:1,created_by:1,custom_status?_count:null,failed_count:1,id:null,is_completed:false,passed_count:1,project_id:1,retest_count:1,untested_count:1,url:\"some url\",name:\"some name\",description:\"some description\",milestone_id:1,entries:[{suite_id:null,config_ids:null,runs:null,name:null,description:null,assignedto_id:null,include_all:null,case_ids:null}],completed_on:1000,created_on:1000}").toString())
    }

    @Test
    fun getPlanTest()
    {

    }

    @Test
    fun getPlansTest()
    {

    }

    @Test
    fun addPlanTest()
    {

    }

    @Test
    fun updatePlanTest()
    {

    }

    @Test
    fun closePlanTest()
    {

    }

    @Test
    fun deletePlanTest()
    {

    }
}