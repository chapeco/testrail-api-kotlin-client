package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Milestone
(
    //GET
        @Transient var completedOn: Timestamp? = null,
        val id: Int? = null,
        val milestones: Array<Milestone>? = null,
        @SerialName("project_id") val projectId: Int? = null,
        @Transient var startedOn: Timestamp? = null,
        val url: String? = null,

    //ADD/UPDATE
        var name: String? = null,
        var description: String? = null,
        @Transient var dueOn: Timestamp? = null,
        @SerialName("parent_id") var parentId: Int? = null,
        @Transient var startOn: Timestamp? = null,

    //UPDATE
        @SerialName("is_completed") var isCompleted: Boolean? = null,
        @SerialName("is_started") var isStarted: Boolean? = null
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
        return Milestone()
    }

    fun getMilestones(projectId: Int, isCompleted: Boolean? = null, isStarted: Boolean? = null): Array<Milestone>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_milestones/$projectId")
        if(isCompleted != null) endpoint.append("&is_completed=$isCompleted")
        if(isStarted != null) endpoint.append("&is_started=$isStarted")
        return Array<Milestone>(0) {Milestone()}
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