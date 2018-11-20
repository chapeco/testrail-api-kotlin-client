package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Run
(
    //GET
        @SerialName("blocked_count") val blockedCount: Int? = null,
        @Transient var completedOn: Timestamp? = null,
        val config: String? = null,
        @SerialName("config_ids") val configIds: Array<Int>? = null,
        @SerialName("created_by") val createdBy: Int? = null,
        @Transient var createdOn: Timestamp? = null,
    //TODO add custom status count 1-7
        @SerialName("custom_status?_count") val customStatusCount: Int? = null,
        @SerialName("failed_count") val failedCount: Int? = null,
        val id: Int? = null,
        @SerialName("is_completed") val isCompleted: Boolean? = null,
        @SerialName("plan_id") val planId: Int? = null,
        @SerialName("passed_count") val passedCount: Int? = null,
        @SerialName("project_id") val projectId: Int? = null,
        @SerialName("retest_count") val retestCount: Int? = null,
        @SerialName("untested_count") val untestedCount: Int? = null,
        val url: String? = null,

    //ADD
        @SerialName("suite_id") var suiteId: Int? = null,
        @SerialName("assignedto_id") var assignedToId: Int? = null,

    //ADD/UPDATE
        var name: String? = null,
        var description: String? = null,
        @SerialName("milestone_id") var milestoneId: Int? = null,
        @SerialName("include_all") var includeAll: Boolean? = null,
        @SerialName("case_ids") var caseIds: Array<Int>? = null
)
{
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()
    @Optional @SerialName("created_on") val createdOnActual: Long? = createdOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
        if(createdOn == null) createdOn = Timestamp(createdOnActual)
    }

    //TODO
    fun getRun(runId: Int): Run
    {
        val endpoint = "get_run/$runId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getRuns
    (
        projectId: Int,
        createdAfter: Timestamp? = null,
        createdBefore: Timestamp? = null,
        createdBy: Array<Int>? = null,
        isCompleted: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null,
        milestoneId: Array<Int>? = null,
        suiteId: Array<Int>? = null
    ): List<Run>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_runs/$projectId")
        if(createdAfter != null) endpoint.append("&created_after=$createdAfter")
        if(createdBefore != null) endpoint.append("&created_before=$createdBefore")
        if(createdBy != null) endpoint.append("&created_by=$createdBy")
        if(isCompleted != null) endpoint.append("&is_completed=$isCompleted")
        if(limit != null) endpoint.append("&limit=$limit")
        if(offset != null) endpoint.append("&offset=$offset")
        if(milestoneId != null) endpoint.append("&milestone_id=$milestoneId")
        if(suiteId != null) endpoint.append("&suite_id=$suiteId")

        return JSON.unquoted.parse(Run.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun addRun(projectId: Int): Run
    {
        val endpoint = "add_run/$projectId"
        return Run()
    }

    fun updateRun(runId: Int): Run
    {
        val endpoint = "update_run/$runId"
        return Run()
    }

    fun closeRun(runId: Int): Run
    {
        val endpoint = "close_run/$runId"
        return Run()
    }

    fun deleteRun(runId: Int)
    {
        val endpoint = "delete_run/$runId"

    }
}