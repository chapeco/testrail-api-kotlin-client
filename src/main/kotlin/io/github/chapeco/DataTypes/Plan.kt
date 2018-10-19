package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp

data class Plan
(
    //Read Only
    val assignedToId: Int? = null,
    val blockedCount: Int? = null,
    val completedOn: Timestamp? = null,
    val createdBy: Int? = null,
    val createdOn: Timestamp? = null,
    val customStatusCount: Int? = null,
    val failedCount: Int? = null,
    val id: Int? = null,
    val isCompleted: Boolean? = null,
    val passedCount: Int? = null,
    val projectId: Int? = null,
    val retestCount: Int? = null,
    val untestedCount: Int? = null,
    val url: String? = null,

    //Read/Write
    var name: String,
    var description: String? = null,
    var milestoneId: Int? = null,
    var entries: Array<PlanEntry>? = null
)
{
    data class PlanEntry
    (
        var suiteId: Int? = null,
        var name: String? = null,
        var description: String? = null,
        var assignedToId: Int? = null,
        var includeAll: Boolean? = null,
        var caseIds: Array<Int>? = null,
        var configIds: Array<Int>? = null,
        var runs: Array<Run>? = null
    )
    {

    }
}