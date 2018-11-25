package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RunTest
{
    @Test
    fun instantiateRunTest()
    {
        val expectedRun = Run(
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                config = "some config",
                configIds = List<Int>(1) {1},
                createdBy = 1,
                createdOn = Timestamp(
                        time = 500
                ),
                failedCount = 1,
                isCompleted = false,
                planId = 1,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                suiteId = 1,
                assignedToId = 1,
                name = "some name",
                description = "some description",
                milestoneId = 1,
                includeAll = true,
                caseIds = List<Int>(1) {1}
        )
        val actualRun = Run(
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                config = "some config",
                configIds = List<Int>(1) {1},
                createdBy = 1,
                createdOn = Timestamp(
                        time = 500
                ),
                failedCount = 1,
                isCompleted = false,
                planId = 1,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                suiteId = 1,
                assignedToId = 1,
                name = "some name",
                description = "some description",
                milestoneId = 1,
                includeAll = true,
                caseIds = List<Int>(1) {1}
        )
        Assertions.assertEquals(expectedRun.toString(),actualRun.toString())
    }

    @Test
    fun serializeRunTest()
    {
        val expectedRun: String = "{blocked_count:1,config:\"some config\",config_ids:[1],created_by:1,custom_status?_count:null,failed_count:1,id:null,is_completed:false,plan_id:1,passed_count:1,project_id:1,retest_count:1,untested_count:1,url:\"some url\",suite_id:1,assignedto_id:1,name:\"some name\",description:\"some description\",milestone_id:1,include_all:true,case_ids:[1],completed_on:1000,created_on:500}"
        val actualRun = Run(
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                config = "some config",
                configIds = List<Int>(1) {1},
                createdBy = 1,
                createdOn = Timestamp(
                        time = 500
                ),
                failedCount = 1,
                isCompleted = false,
                planId = 1,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                suiteId = 1,
                assignedToId = 1,
                name = "some name",
                description = "some description",
                milestoneId = 1,
                includeAll = true,
                caseIds = List<Int>(1) {1}
        )
        println(JSON.unquoted.stringify(actualRun))
        Assertions.assertEquals(expectedRun,JSON.unquoted.stringify(actualRun))
    }

    @Test
    fun deserializeRunTest()
    {
        val expectedRun = Run(
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                config = "some config",
                configIds = List<Int>(1) {1},
                createdBy = 1,
                createdOn = Timestamp(
                        time = 500
                ),
                failedCount = 1,
                isCompleted = false,
                planId = 1,
                passedCount = 1,
                projectId = 1,
                retestCount = 1,
                untestedCount = 1,
                url = "some url",
                suiteId = 1,
                assignedToId = 1,
                name = "some name",
                description = "some description",
                milestoneId = 1,
                includeAll = true,
                caseIds = List<Int>(1) {1}
        )
        Assertions.assertEquals(expectedRun.toString(),JSON.unquoted.parse<Run>("{blocked_count:1,config:\"some config\",config_ids:[1],created_by:1,custom_status?_count:null,failed_count:1,id:null,is_completed:false,plan_id:1,passed_count:1,project_id:1,retest_count:1,untested_count:1,url:\"some url\",suite_id:1,assignedto_id:1,name:\"some name\",description:\"some description\",milestone_id:1,include_all:true,case_ids:[1],completed_on:1000,created_on:500}").toString())
    }

    @Test
    fun getRunTest()
    {
        val expectedRun = JSON.unquoted.parse<Run>("{blocked_count:0,config:null,config_ids:[],created_by:1,custom_status1_count:0,custom_status2_count:0,custom_status3_count:0,custom_status4_count:0,custom_status5_count:0,custom_status6_count:0,custom_status7_count:0,failed_count:0,id:1,is_completed:false,plan_id:null,passed_count:1,project_id:1,retest_count:0,untested_count:0,url:\"https://techdemo4.testrail.io/index.php?/runs/view/1\",suite_id:1,assignedto_id:null,name:\"API_Test_Suite Run\",description:null,milestone_id:null,include_all:true,case_ids:null,completed_on:null,created_on:1542142925}")
        val actualRun = Run().getRun(1)
        println(JSON.unquoted.stringify(actualRun))
        Assertions.assertEquals(expectedRun,actualRun)
    }

    @Test
    fun getRunsTest()
    {
        val expectedRunsList = listOf(
                JSON.unquoted.parse<Run>("{blocked_count:0,config:null,config_ids:[],created_by:1,custom_status1_count:0,custom_status2_count:0,custom_status3_count:0,custom_status4_count:0,custom_status5_count:0,custom_status6_count:0,custom_status7_count:0,failed_count:0,id:1,is_completed:false,plan_id:null,passed_count:1,project_id:1,retest_count:0,untested_count:0,url:\"https://techdemo4.testrail.io/index.php?/runs/view/1\",suite_id:1,assignedto_id:null,name:\"API_Test_Suite Run\",description:null,milestone_id:null,include_all:true,case_ids:null,completed_on:null,created_on:1542142925}")
        )
        val actualRunsList = Run().getRuns(1)
        println(JSON.unquoted.stringify(Run.serializer().list,actualRunsList))
        Assertions.assertEquals(expectedRunsList,actualRunsList)
    }

    @Test
    fun addRunTest()
    {

    }

    @Test
    fun updateRunTest()
    {

    }

    @Test
    fun closeRunTest()
    {

    }

    @Test
    fun deleteRunTest()
    {

    }
}