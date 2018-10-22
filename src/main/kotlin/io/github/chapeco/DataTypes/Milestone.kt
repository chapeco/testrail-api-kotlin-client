package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Milestone
(
    //GET
    @SerialName("completed_on")
    val completedOn: Timestamp? = null,
    val id: Int? = null,
    val milestones: Array<Milestone>? = null,
    @SerialName("project_id")
    val projectId: Int? = null,
    @SerialName("started_on")
    val startedOn: Timestamp? = null,
    val url: String? = null,

    //ADD/UPDATE
    var name: String? = null,
    var description: String? = null,
    @SerialName("due_on")
    var dueOn: Timestamp? = null,
    @SerialName("parent_id")
    var parentId: Int? = null,
    @SerialName("start_on")
    var startOn: Timestamp? = null,

    //UPDATE
    @SerialName("is_completed")
    var isCompleted: Boolean? = null,
    @SerialName("is_started")
    var isStarted: Boolean? = null

)