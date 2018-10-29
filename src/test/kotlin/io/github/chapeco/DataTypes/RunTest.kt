package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
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
                configIds = Array<Int>(1) {1},
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
                caseIds = Array<Int>(1) {1}
        )
        val actualRun = Run(
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                config = "some config",
                configIds = Array<Int>(1) {1},
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
                caseIds = Array<Int>(1) {1}
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
                configIds = Array<Int>(1) {1},
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
                caseIds = Array<Int>(1) {1}
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
                configIds = Array<Int>(1) {1},
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
                caseIds = Array<Int>(1) {1}
        )
        Assertions.assertEquals(expectedRun.toString(),JSON.unquoted.parse<Run>("{blocked_count:1,config:\"some config\",config_ids:[1],created_by:1,custom_status?_count:null,failed_count:1,id:null,is_completed:false,plan_id:1,passed_count:1,project_id:1,retest_count:1,untested_count:1,url:\"some url\",suite_id:1,assignedto_id:1,name:\"some name\",description:\"some description\",milestone_id:1,include_all:true,case_ids:[1],completed_on:1000,created_on:500}").toString())
    }

    @Test
    fun getRunTest()
    {

    }

    @Test
    fun getRunsTest()
    {

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