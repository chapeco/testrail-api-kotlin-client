package io.github.chapeco.DataTypes

import io.github.chapeco.DataTypes.SubTypes.Step
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timespan
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

/**
 * Serializable data class for the TestRail Test DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-tests
 */
@Serializable
data class TestObj
(
        @Optional @SerialName("assignedto_id") val assignedToId: Int? = null,
        @Optional @SerialName("case_id") val caseId: Int? = null,
        @Transient var estimate: Timespan? = null,
        @Transient var estimateForecast: Timespan? = null,
        @Optional val id: Int? = null,
        @Optional @SerialName("milestone_id") val milestoneId: Int? = null,
        @Optional @SerialName("priority_id") val priorityId: Int? = null,
        @Optional val refs: String? = null,
        @Optional @SerialName("run_id") val runId: Int? = null,
        @Optional @SerialName("status_id") val statusId: Int? = null,
        @Optional val title: String? = null,
        @Optional @SerialName("type_id") val typeId: Int? = null,
        @Optional @SerialName("template_id") val templateId: Int? = null,
        @Optional @SerialName("custom_automation_type") val customAutomationType: String? = null,
        @Optional @SerialName("custom_expected") val customExpected: String? = null,
        @Optional @SerialName("custom_preconds") val customPreconds: String? = null,
        @Optional @SerialName("custom_steps_separated") val customStepsSeparated: List<Step>? = null,
        @Optional @SerialName("custom_steps") val customSteps: String? = null,
        @Optional @SerialName("custom_mission") val customMission: String? = null,
        @Optional @SerialName("custom_goals") val customGoals: String? = null
)
{
    @Optional @SerialName("estimate") private val estimateActual: String? = estimate.toString()
    @Optional @SerialName("estimate_forecast") private val estimateForecastActual: String? = estimateForecast.toString()

    init {
        if(estimate == null) estimate = Timespan().parseTimespan(estimateActual)
        if(estimateForecast == null) estimateForecast = Timespan().parseTimespan(estimateForecastActual)
    }

    fun getTest(testId: Int): TestObj
    {
        val endpoint = "get_test/$testId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getTests(runId: Int, statusId: Int? = null): List<TestObj>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_tests/$runId")
        if(statusId != null) endpoint.append("&status_id=$statusId")
        return JSON.unquoted.parse(TestObj.serializer().list, Request().Get(endpoint.toString())!!)
    }
}