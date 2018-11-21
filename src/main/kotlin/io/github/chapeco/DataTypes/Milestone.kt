package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Milestone
(
    //GET
        @Optional @Transient var completedOn: Timestamp? = null,
        @Optional val id: Int? = null,
        @Optional val milestones: List<Milestone>? = null,
        @Optional @SerialName("project_id") val projectId: Int? = null,
        @Optional @Transient var startedOn: Timestamp? = null,
        @Optional val url: String? = null,

    //ADD/UPDATE
        @Optional var name: String? = null,
        @Optional var description: String? = null,
        @Optional @Transient var dueOn: Timestamp? = null,
        @Optional @SerialName("parent_id") var parentId: Int? = null,
        @Optional @Transient var startOn: Timestamp? = null,

    //UPDATE
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

    //TODO
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

    fun addMilestone(projectId: Int): Milestone
    {
        val endpoint = "add_milestone/$projectId"
        return Milestone()
    }

    fun updateMilestone(milestoneId: Int): Milestone
    {
        val endpoint = "update_milestone/$milestoneId"
        return Milestone()
    }

    fun deleteMilestone(milestoneId: Int)
    {
        val endpoint = "delete_milestone/$milestoneId"
    }
}