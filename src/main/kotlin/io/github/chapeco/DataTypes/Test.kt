package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Test
(
    @SerialName("assignedto_id") val assignedToId: Int? = null,
    @SerialName("case_id") val caseId: Int? = null,
    val estimate: Timespan? = null,
    @SerialName("estimate_forecast") val estimateForecast: Timespan? = null,
    val id: Int? = null,
    @SerialName("milestone_id") val milestoneId: Int? = null,
    @SerialName("priority_id") val priorityId: Int? = null,
    val refs: String? = null,
    @SerialName("run_id") val runId: Int? = null,
    @SerialName("status_id") val statusId: Int? = null,
    val title: String? = null,
    @SerialName("type_id") val typeId: Int? = null
)