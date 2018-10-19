package io.github.chapeco.DataTypes

data class Milestone
(
    val id: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var dueOn: Timestamp? = null,
    var parentId: Int? = null,
    var startOn: Timestamp? = null
)