package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Plan
(
    //GET
        @SerialName("assignedto_id") val assignedToId: Int? = null,
        @SerialName("blocked_count") val blockedCount: Int? = null,
        @Transient var completedOn: Timestamp? = null,
        @SerialName("created_by") val createdBy: Int? = null,
        @Transient var createdOn: Timestamp? = null,
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
        var name: String? = null,
        var description: String? = null,
        @SerialName("milestone_id") var milestoneId: Int? = null,
        var entries: Array<PlanEntry>? = null
)
{
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()
    @Optional @SerialName("created_on") val createdOnActual: Long? = createdOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
        if(createdOn == null) createdOn = Timestamp(createdOnActual)
    }

    //TODO
    fun getPlan(planId: Int): Plan
    {
        val endpoint = "get_plan/$planId"
        return Plan()
    }

    fun getPlans
    (
        projectId: Int,
        createdAfter: Timestamp? = null,
        createdBefore: Timestamp? = null,
        createdBy: Array<Int>? = null,
        isCompleted: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null,
        milestoneId: Array<Int>? = null
    ): Array<Plan>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_plans/$projectId")
        if(createdAfter != null) endpoint.append("&created_after=$createdAfter")
        if(createdBefore != null) endpoint.append("&created_before=$createdBefore")
        if(createdBy != null) endpoint.append("&created_by=$createdBy")
        if(isCompleted != null) endpoint.append("&is_completed=$isCompleted")
        if(limit != null) endpoint.append("&limit=$limit")
        if(offset != null) endpoint.append("&offset=$offset")
        if(milestoneId != null) endpoint.append("&milestone_id=$milestoneId")
        return Array<Plan>(0) {Plan()}
    }

    fun addPlan(projectId: Int): Plan
    {
        val endpoint = "add_plan/$projectId"
        return Plan()
    }

    fun updatePlan(planId: Int): Plan
    {
        val endpoint = "update_plan/$planId"
        return Plan()
    }

    fun closePlan(planId: Int): Plan
    {
        val endpoint = "close_plan/$planId"
        return Plan()
    }

    fun deletePlan(planId: Int)
    {
        val endpoint = "delete_plan/$planId"
    }
}