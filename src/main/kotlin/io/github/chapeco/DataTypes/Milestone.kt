package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

/**
 * Serializable data class for the TestRail Milestone DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-milestones
 */
@Serializable
data class Milestone
(
        @Optional @Transient var completedOn: Timestamp? = null,
        @Optional val id: Int? = null,
        @Optional val milestones: List<Milestone>? = null,
        @Optional @SerialName("project_id") val projectId: Int? = null,
        @Optional @Transient var startedOn: Timestamp? = null,
        @Optional val url: String? = null,
        @Optional var name: String? = null,
        @Optional var description: String? = null,
        @Optional @Transient var dueOn: Timestamp? = null,
        @Optional @SerialName("parent_id") var parentId: Int? = null,
        @Optional @Transient var startOn: Timestamp? = null,
        @Optional @SerialName("is_completed") var isCompleted: Boolean? = null,
        @Optional @SerialName("is_started") var isStarted: Boolean? = null
)
{
    @Optional @SerialName("completed_on") private val completedOnActual: Long? = completedOn.toString().toLongOrNull()
    @Optional @SerialName("started_on") private val startedOnActual: Long? = startedOn.toString().toLongOrNull()
    @Optional @SerialName("due_on") private val dueOnActual: Long? = dueOn.toString().toLongOrNull()
    @Optional @SerialName("start_on") private val startOnActual: Long? = startOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
        if(startedOn == null) startedOn = Timestamp(startedOnActual)
        if(dueOn == null) dueOn = Timestamp(dueOnActual)
        if(startOn == null) startOn = Timestamp(startOnActual)
    }

    fun getMilestone(milestoneId: Int): Milestone
    {
        val endpoint = "get_milestone/$milestoneId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getMilestones(projectId: Int, isCompleted: Boolean? = null, isStarted: Boolean? = null): List<Milestone>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_milestones/$projectId")
        if(isCompleted != null) endpoint.append("&is_completed=$isCompleted")
        if(isStarted != null) endpoint.append("&is_started=$isStarted")
        return JSON.unquoted.parse(Milestone.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun addMilestone(): Milestone
    {
        if(this.projectId == null) throw MissingRequiredParamException("projectId")
        val projectId = this.projectId
        val endpoint = "add_milestone/$projectId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateMilestone(): Milestone
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val milestoneId = this.id
        val endpoint = "update_milestone/$milestoneId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deleteMilestone()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val milestoneId = this.id
        val endpoint = "delete_milestone/$milestoneId"
        Request().Post(endpoint)
    }
}