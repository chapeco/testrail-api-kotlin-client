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
        Assertions.assertEquals(expectedRun,actualRun)
    }

    @Test
    fun serializeRunTest()
    {
        val expectedRun: String = ""
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
        Assertions.assertEquals(expectedRun,JSON.unquoted.parse<Run>(""))
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