package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

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
                entries = List<PlanEntry>(1) { PlanEntry() }

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
                entries = List<PlanEntry>(1) {PlanEntry()}
        )
        Assert.assertEquals(expectedPlan.toString(),actualPlan.toString())
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
                entries = List<PlanEntry>(1) {PlanEntry()}
        )
        println(JSON.unquoted.stringify(actualPlan))
        Assert.assertEquals(expectedPlan,JSON.unquoted.stringify(actualPlan))
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
                entries = List<PlanEntry>(1) {PlanEntry()}
        )
        Assert.assertEquals(expectedPlan.toString(),JSON.unquoted.parse<Plan>("{assignedto_id:1,blocked_count:1,created_by:1,custom_status?_count:null,failed_count:1,id:null,is_completed:false,passed_count:1,project_id:1,retest_count:1,untested_count:1,url:\"some url\",name:\"some name\",description:\"some description\",milestone_id:1,entries:[{suite_id:null,config_ids:null,runs:null,name:null,description:null,assignedto_id:null,include_all:null,case_ids:null}],completed_on:1000,created_on:1000}").toString())
    }

    @Test
    fun getPlanTest()
    {
        val expectedPlan = Plan(
                blockedCount = 0,
                createdBy = 1,
                customStatus1Count = 0,
                customStatus2Count = 0,
                customStatus3Count = 0,
                customStatus4Count = 0,
                customStatus5Count = 0,
                customStatus6Count = 0,
                customStatus7Count = 0,
                failedCount = 0,
                id = 2,
                isCompleted = false,
                passedCount = 0,
                projectId = 1,
                retestCount = 0,
                untestedCount = 0,
                url = "https://techdemo4.testrail.io/index.php?/plans/view/2",
                name = "API TEST Plan",
                description = "My plan description.",
                milestoneId = 1,
                entries = listOf<PlanEntry>(),
                createdOn = Timestamp(1542820883)
        )
        val actualPlan = Plan().getPlan(2)
        println(JSON.unquoted.stringify(actualPlan))
        Assert.assertEquals(expectedPlan,actualPlan)
    }

    @Test
    fun getPlansTest()
    {
        val expectedPlansList = listOf(
                Plan(
                        blockedCount = 0,
                        createdBy = 1,
                        customStatus1Count = 0,
                        customStatus2Count = 0,
                        customStatus3Count = 0,
                        customStatus4Count = 0,
                        customStatus5Count = 0,
                        customStatus6Count = 0,
                        customStatus7Count = 0,
                        failedCount = 0,
                        id = 2,
                        isCompleted = false,
                        passedCount = 0,
                        projectId = 1,
                        retestCount = 0,
                        untestedCount = 0,
                        url = "https://techdemo4.testrail.io/index.php?/plans/view/2",
                        name = "API TEST Plan",
                        description = "My plan description.",
                        milestoneId = 1,
                        createdOn = Timestamp(1542820883)
                )
        )
        val actualPlansList = Plan().getPlans(1)
        println(JSON.unquoted.stringify(Plan.serializer().list,actualPlansList))
        Assert.assertEquals(expectedPlansList,actualPlansList)
    }

    @Test
    fun addPlanTest()
    {
        val expectedPlan = Plan(name = "API TEST Plan",projectId = 1)
        val actualPlan = expectedPlan.addPlan()
        println(JSON.unquoted.stringify(actualPlan))
        Assert.assertEquals(expectedPlan.name,actualPlan.name)
    }

    @Test
    fun updatePlanTest()
    {
        val expectedUpdatedPlan = Plan(name = "API TEST Updated Plan",id = 1)
        val actualUpdatedPlan = expectedUpdatedPlan.updatePlan()
        println(JSON.unquoted.stringify(actualUpdatedPlan))
        Assert.assertEquals(expectedUpdatedPlan.name,actualUpdatedPlan.name)
    }

    @Test
    fun closePlanTest()
    {
        val expectedClosedPlan = Plan(id = 1)
        val actualClosedPlan = expectedClosedPlan.closePlan()
        println(JSON.unquoted.stringify(actualClosedPlan))
        Assert.assertTrue(actualClosedPlan.isCompleted!!)
    }

    @Test
    fun deletePlanTest()
    {
        val expectedDeletedPlan = Plan(id = 1)
        expectedDeletedPlan.deletePlan()
    }
}