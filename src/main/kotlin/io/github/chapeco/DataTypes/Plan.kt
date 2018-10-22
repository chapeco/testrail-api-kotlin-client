package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Plan
(
    //GET
    @SerialName("assignedto_id") val assignedToId: Int? = null,
    @SerialName("blocked_count") val blockedCount: Int? = null,
    @SerialName("completed_on") val completedOn: Timestamp? = null,
    @SerialName("created_by") val createdBy: Int? = null,
    @SerialName("created_on") val createdOn: Timestamp? = null,
    //TODO Add status count 1-7
    @SerialName("custom_status?_count") val customStatusCount: Int? = null,
    @SerialName("failed_count") val failedCount: Int? = null,
    val id: Int? = null,
    @SerialName("is_completed") val isCompleted: Boolean? = null,
    @SerialName("passed_count") val passedCount: Int? = null,
    @SerialName("project_id") val projectId: Int? = null,
    @SerialName("retest_count") val retestCount: Int? = null,
    @SerialName("untested_count") val untestedCount: Int? = null,
    val url: String? = null,

    //ADD/UPDATE
    var name: String,
    var description: String? = null,
    @SerialName("milestone_id") var milestoneId: Int? = null,
    var entries: Array<PlanEntry>? = null
)
{
    @Serializable
    data class PlanEntry
    (
        //ADD
        @SerialName("suite_id") var suiteId: Int? = null,
        @SerialName("config_ids") var configIds: Array<Int>? = null,
        var runs: Array<Run>? = null,

        //ADD/UPDATE
        var name: String? = null,
        var description: String? = null,
        @SerialName("assignedto_id") var assignedToId: Int? = null,
        @SerialName("include_all") var includeAll: Boolean? = null,
        @SerialName("case_ids") var caseIds: Array<Int>? = null
    )
    {

    }
}