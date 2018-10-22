package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp

data class Suite
(
    val completedOn: Timestamp? = null,
    val id: Int? = null,
    val isBaseline: Boolean? = null,
    val isCompleted: Boolean? = null,
    val isMaster: Boolean? = null,
    val projectId: Int? = null,
    val url: String? = null,

    var name: String? = null,
    var description: String? = null
)
{}