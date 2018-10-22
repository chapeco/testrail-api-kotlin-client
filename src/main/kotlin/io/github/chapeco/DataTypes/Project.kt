package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project
(
    //GET
    val id: Int? = null,
    @SerialName("completed_on") val completedOn: Timestamp? = null,
    val url: String? = null,

    //ADD/UPDATE
    var name: String? = null,
    var announcement: String? = null,
    @SerialName("show_announcement") var showAnnouncement: Boolean? = null,
    @SerialName("suite_mode") var suiteMode: Int? = null,

    //UPDATE
    @SerialName("is_completed") var isCompleted: Boolean? = null
)