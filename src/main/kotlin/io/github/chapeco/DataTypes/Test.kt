package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Test
(
        @SerialName("assignedto_id") val assignedToId: Int? = null,
        @SerialName("case_id") val caseId: Int? = null,
        @Transient var estimate: Timespan? = null,
        @Transient var estimateForecast: Timespan? = null,
        val id: Int? = null,
        @SerialName("milestone_id") val milestoneId: Int? = null,
        @SerialName("priority_id") val priorityId: Int? = null,
        val refs: String? = null,
        @SerialName("run_id") val runId: Int? = null,
        @SerialName("status_id") val statusId: Int? = null,
        val title: String? = null,
        @SerialName("type_id") val typeId: Int? = null
)
{
    @Optional @SerialName("estimate") private val estimateActual: String? = estimate.toString()
    @Optional @SerialName("estimate_forecast") private val estimateForecastActual: String? = estimateForecast.toString()

    init {
        if(estimate == null) estimate = Timespan().parseTimespan(estimateActual)
        if(estimateForecast == null) estimateForecast = Timespan().parseTimespan(estimateForecastActual)
    }
    //TODO
    fun getTest(testId: Int): Test
    {
        val endpoint = "get_test/$testId"
        return Test()
    }

    fun getTests(runId: Int, statusId: Int? = null): Array<Test>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_tests/$runId")
        if(statusId != null) endpoint.append("&status_id=$statusId")

        return Array<Test>(0) {Test()}
    }
}