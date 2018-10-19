package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp

data class Milestone
(
    //Read Only
    val completedOn: Timestamp? = null,
    val id: Int? = null,
    val milestones: Array<Milestone>? = null,
    val projectId: Int? = null,
    val startedOn: Timestamp? = null,
    val url: String? = null,

    //Read/Write
    var isCompleted: Boolean? = null,
    var isStarted: Boolean? = null,
    var name: String? = null,
    var description: String? = null,
    var dueOn: Timestamp? = null,
    var parentId: Int? = null,
    var startOn: Timestamp? = null
)