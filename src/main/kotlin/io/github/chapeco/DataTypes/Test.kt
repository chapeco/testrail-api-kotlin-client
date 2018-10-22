package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan

data class Test
(
    val assignedToId: Int? = null,
    val caseId: Int? = null,
    val estimate: Timespan? = null,
    val estimateForecast: Timespan? = null,
    val id: Int? = null,
    val milestoneId: Int? = null,
    val priorityId: Int? = null,
    val refs: String? = null,
    val runId: Int? = null,
    val statusId: Int? = null,
    val title: String? = null,
    val typeId: Int? = null
)