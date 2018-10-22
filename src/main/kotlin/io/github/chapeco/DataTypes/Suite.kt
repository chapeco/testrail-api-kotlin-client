package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Suite
(
    //GET
    @SerialName("completed_on")
    val completedOn: Timestamp? = null,
    val id: Int? = null,
    @SerialName("is_baseline")
    val isBaseline: Boolean? = null,
    @SerialName("is_completed")
    val isCompleted: Boolean? = null,
    @SerialName("is_master")
    val isMaster: Boolean? = null,
    @SerialName("project_id")
    val projectId: Int? = null,
    val url: String? = null,

    //ADD/UPDATE
    var name: String? = null,
    var description: String? = null
)
{}