package io.github.chapeco.DataTypes

import io.github.chapeco.DataTypes.SubTypes.Results
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Result
(
    //GET
        @Optional @Transient var createdBy: Int? = null,
        @Optional @Transient var createdOn: Timestamp? = null,
        @Optional @Transient var id: Int? = null,
        @Optional @Transient var testId: Int? = null,
        @Optional @Transient var caseId: Int? = null,

    //ADD
        @Optional @SerialName("status_id") var statusId: Int? = -1,
        @Optional var comment: String? = "",
        @Optional var version: String? = "",
        @Optional @Transient var elapsed: Timespan? = null,
        @Optional var defects: String? = "",
        @Optional @Transient var assignedToId: Int? = null,
        @Optional @SerialName("custom_step_results") val customStepResults: String? = ""
)
{
    @Optional @SerialName("created_on") private val createdOnActual: String? = if (createdOn == null) "" else createdOn.toString()
    @Optional @SerialName("elapsed") private val elapsedActual: String? = if (elapsed == null) "" else elapsed.toString()
    @Optional @SerialName("assignedto_id") private val assignedToIdActual: String? = if (assignedToId == null) "" else assignedToId.toString()
    @Optional @SerialName("created_by") private val createdByActual: String? = if (createdBy == null) "" else createdBy.toString()
    @Optional @SerialName("id") private val idActual: String? = if (id == null) "" else id.toString()
    @Optional @SerialName("test_id") private val testIdActual: String? = if (testId == null) "" else testId.toString()
    @Optional @SerialName("case_id") private val caseIdActual: String? = if (caseId == null) "" else caseId.toString()

    init {
        if(createdOn == null) createdOn = Timestamp(createdOnActual?.toLongOrNull())
        if(elapsed == null && elapsedActual != "") elapsed = Timespan().parseTimespan(elapsedActual)
        if(assignedToId == null && assignedToIdActual != "") assignedToId = assignedToIdActual?.toInt()
        if(createdBy == null && createdByActual != "") createdBy = createdByActual?.toInt()
        if(id == null && idActual != "") id = idActual?.toInt()
        if(testId == null && testIdActual != "") testId = testIdActual?.toInt()
        if(caseId == null && caseIdActual != "") caseId = caseIdActual?.toInt()
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
        val testId = result.testId
        val endpoint = "add_result/$testId"
        println(JSON.stringify(result))
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(result))!!)
    }

    fun addResultForCase(runId: Int, caseId: Int, result: Result): Result
    {
        val endpoint = "add_result_for_case/$runId/$caseId"
        println(JSON.stringify(result))
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(result))!!)
    }

    fun addResults(runId: Int, results: Results): List<Result>
    {
        val endpoint = "add_results/$runId"
        println(JSON.stringify(results))
        return JSON.unquoted.parse(Result.serializer().list,Request().Post(endpoint,JSON.stringify(results))!!)
    }

    fun addResultsForCases(runId: Int, results: Results): List<Result>
    {
        val endpoint = "add_results_for_cases/$runId"
        println(JSON.stringify(results))
        return JSON.unquoted.parse(Result.serializer().list,Request().Post(endpoint,JSON.stringify(results))!!)
    }
}