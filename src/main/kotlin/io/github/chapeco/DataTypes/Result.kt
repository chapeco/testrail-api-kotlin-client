package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result
(
    //GET
    @SerialName("created_by") val createdBy: Int? = null,
    @SerialName("created_on") val createdOn: Timestamp? = null,
    val id: Int? = null,
    @SerialName("test_id") val testId: Int? = null,

    //ADD
    @SerialName("status_id") var statusId: Int? = null,
    var comment: String? = null,
    var version: String? = null,
    var elapsed: Timespan? = null,
    var defects: String? = null,
    @SerialName("assignedto_id") var assignedToId: Int? = null
)
{
    //TODO
    fun getResults(testId: Int): Array<Result>
    {
        val endpoint = "get_results/$testId"
        return Array<Result>(0) {Result()}
    }

    fun getResultsForCase(runId: Int, caseId: Int): Array<Result>
    {
        val endpoint = "get_results_for_case/$runId/$caseId"
        return Array<Result>(0) {Result()}
    }

    fun getResultsForRun(runId: Int): Array<Result>
    {
        val endpoint = "get_results_for_run/$runId"
        return Array<Result>(0) {Result()}
    }

    fun addResult(testId: Int): Result
    {
        val endpoint = "add_result/$testId"
        return Result()
    }

    fun addResultForCase(runId: Int, caseId: Int): Result
    {
        val endpoint = "add_result_for_case/$runId/$caseId"
        return Result()
    }

    fun addResults(runId: Int): Array<Result>
    {
        val endpoint = "add_results/$runId"
        return Array<Result>(0) {Result()}
    }

    fun addResultsForCases(runId: Int): Array<Result>
    {
        val endpoint = "add_results_for_cases/$runId"
        return Array<Result>(0) {Result()}
    }
}