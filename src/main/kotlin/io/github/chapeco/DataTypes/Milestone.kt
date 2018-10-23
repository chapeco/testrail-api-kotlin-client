package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Milestone
(
    //GET
    @SerialName("completed_on") val completedOn: Timestamp? = null,
    val id: Int? = null,
    val milestones: Array<Milestone>? = null,
    @SerialName("project_id") val projectId: Int? = null,
    @SerialName("started_on") val startedOn: Timestamp? = null,
    val url: String? = null,

    //ADD/UPDATE
    var name: String? = null,
    var description: String? = null,
    @SerialName("due_on") var dueOn: Timestamp? = null,
    @SerialName("parent_id") var parentId: Int? = null,
    @SerialName("start_on") var startOn: Timestamp? = null,

    //UPDATE
    @SerialName("is_completed") var isCompleted: Boolean? = null,
    @SerialName("is_started") var isStarted: Boolean? = null
)
{
    //TODO
    fun getMilestone(milestoneId: Int): Milestone
    {
        val endpoint = "get_milestone/"
        return Milestone()
    }

    fun getMilestones(projectId: Int): Array<Milestone>
    {
        val endpoint = "get_milestones/"
        return Array<Milestone>(0) {Milestone()}
    }

    fun addMilestone(projectId: Int): Milestone
    {
        val endpoint = "add_milestone/"
        return Milestone()
    }

    fun updateMilestone(milestoneId: Int): Milestone
    {
        val endpoint = "update_milestone/"
        return Milestone()
    }

    fun deleteMilestone(milestoneId: Int)
    {
        val endpoint = "delete_milestone/"
    }
}