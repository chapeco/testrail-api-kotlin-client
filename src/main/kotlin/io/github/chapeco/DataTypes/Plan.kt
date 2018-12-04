package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

/**
 * Serializable data class for the TestRail Plan DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-plans
 */
@Serializable
data class Plan
(
        @Optional @SerialName("assignedto_id") val assignedToId: Int? = null,
        @Optional @SerialName("blocked_count") val blockedCount: Int? = null,
        @Optional @Transient var completedOn: Timestamp? = null,
        @Optional @SerialName("created_by") val createdBy: Int? = null,
        @Optional @Transient var createdOn: Timestamp? = null,
        @Optional @SerialName("custom_status1_count") val customStatus1Count: Int? = null,
        @Optional @SerialName("custom_status2_count") val customStatus2Count: Int? = null,
        @Optional @SerialName("custom_status3_count") val customStatus3Count: Int? = null,
        @Optional @SerialName("custom_status4_count") val customStatus4Count: Int? = null,
        @Optional @SerialName("custom_status5_count") val customStatus5Count: Int? = null,
        @Optional @SerialName("custom_status6_count") val customStatus6Count: Int? = null,
        @Optional @SerialName("custom_status7_count") val customStatus7Count: Int? = null,
        @Optional @SerialName("failed_count") val failedCount: Int? = null,
        @Optional val id: Int? = null,
        @Optional @SerialName("is_completed") val isCompleted: Boolean? = null,
        @Optional @SerialName("passed_count") val passedCount: Int? = null,
        @Optional @SerialName("project_id") val projectId: Int? = null,
        @Optional @SerialName("retest_count") val retestCount: Int? = null,
        @Optional @SerialName("untested_count") val untestedCount: Int? = null,
        @Optional val url: String? = null,
        @Optional var name: String? = null,
        @Optional var description: String? = null,
        @Optional @SerialName("milestone_id") var milestoneId: Int? = null,
        @Optional var entries: List<PlanEntry>? = null
)
{
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()
    @Optional @SerialName("created_on") val createdOnActual: Long? = createdOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
        if(createdOn == null) createdOn = Timestamp(createdOnActual)
    }

    fun getPlan(planId: Int): Plan
    {
        val endpoint = "get_plan/$planId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
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
    ): List<Plan>
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
        return JSON.unquoted.parse(Plan.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun addPlan(): Plan
    {
        if(this.projectId == null) throw MissingRequiredParamException("projectId")
        val projectId = this.projectId
        val endpoint = "add_plan/$projectId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updatePlan(): Plan
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val planId = this.id
        val endpoint = "update_plan/$planId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun closePlan(): Plan
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val planId = this.id
        val endpoint = "close_plan/$planId"
        return JSON.unquoted.parse(Request().Post(endpoint)!!)
    }

    fun deletePlan()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val planId = this.id
        val endpoint = "delete_plan/$planId"
        Request().Post(endpoint)
    }
}