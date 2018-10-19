package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp

data class Project
(
    //Read Only
    val id: Int? = null,
    val completedOn: Timestamp? = null,
    val url: String? = null,

    //Read/Write
    var isCompleted: Boolean? = null,
    var name: String? = null,
    var announcement: String? = null,
    var showAnnouncement: Boolean? = null,
    var suiteMode: Int? = null
)
{
}