package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Result
(
    //GET
        @SerialName("created_by") val createdBy: Int? = null,
        @Transient var createdOn: Timestamp? = null,
        val id: Int? = null,
        @SerialName("test_id") val testId: Int? = null,

    //ADD
        @SerialName("status_id") var statusId: Int? = null,
        var comment: String? = null,
        var version: String? = null,
        @Transient var elapsed: Timespan? = null,
        var defects: String? = null,
        @SerialName("assignedto_id") var assignedToId: Int? = null
)
{
    @Optional @SerialName("created_on") private val createdOnActual: Long? = if(createdOn != null) createdOn.toString().toLong() else -1
    @Optional @SerialName("elapsed") private val elapsedActual: String? = if(elapsed != null) elapsed.toString() else "-1"

    init {
        if(createdOn == null) createdOn = Timestamp(createdOnActual)
        if(elapsed == null) elapsed = Timespan().parseTimespan(elapsedActual!!)
    }

    //TODO
    fun getResults
    (
        testId: Int,
        limit: Int? = null,
        offset: Int? = null,
        statusId: Array<Int>? = null
    ): List<Result>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_results/$testId")
        if(limit != null) endpoint.append("&limit=$limit")
        if(offset != null) endpoint.append("&offset=$offset")
        if(statusId != null) endpoint.append("&status_id=$statusId")

        return JSON.unquoted.parse(Result.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun getResultsForCase
    (
        runId: Int,
        caseId: Int,
        limit: Int? = null,
        offset: Int? = null,
        statusId: Int? = null
    ): List<Result>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_results_for_case/$runId/$caseId")
        if(limit != null) endpoint.append("&limit=$limit")
        if(offset != null) endpoint.append("&offset=$offset")
        if(statusId != null) endpoint.append("&status_id=$statusId")

        return JSON.unquoted.parse(Result.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun getResultsForRun
    (
        runId: Int,
        createdAfter: Timestamp? = null,
        createdBefore: Timestamp? = null,
        createdBy: Array<Int>? = null,
        limit: Int? = null,
        offset: Int? = null,
        statusId: Array<Int>? = null
    ): List<Result>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_results_for_run/$runId")
        if(createdAfter != null) endpoint.append("&created_after=$createdAfter")
        if(createdBefore != null) endpoint.append("&created_before=$createdBefore")
        if(createdBy != null) endpoint.append("&created_by=$createdBy")
        if(limit != null) endpoint.append("&limit=$limit")
        if(offset != null) endpoint.append("&offset=$offset")
        if(statusId != null) endpoint.append("&status_id=$statusId")

        return JSON.unquoted.parse(Result.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun addResult(result: Result): Result
    {
        val endpoint = "add_result/$testId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(Result))!!)
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