package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import io.github.chapeco.Utilities.Request
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

/**
 * Serializable data class for the TestRail Case DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-cases
 */
@Serializable
data class Case
(
        @Optional @SerialName("created_by") val createdBy: Int? = null,
        @Transient var createdOn: Timestamp? = null,
        @Transient var estimateForecast: Timespan? = null,
        @Optional val id: Int? = null,
        @Optional @SerialName("section_id") val sectionId: Int? = null,
        @Optional @SerialName("suite_id") val suiteId: Int? = null,
        @Optional @SerialName("updated_by") val updatedBy: Int? = null,
        @Transient var updatedOn: Timestamp? = null,

        @Optional var title: String? = null,
        @Optional @SerialName("template_id") var templateId: Int? = null,
        @Optional @SerialName("type_id") var typeId: Int? = null,
        @Optional @SerialName("priority_id") var priorityId: Int? = null,
        @Transient var estimate: Timespan? = null,
        @Optional @SerialName("milestone_id") var milestoneId: Int? = null,
        @Optional var refs: String? = null,
        @Optional @SerialName("custom_automation_type") var automationType: String? = null,
        @Optional @SerialName("custom_expected") var expected: String? = null,
        @Optional @SerialName("custom_preconds") var preconds: String? = null,
        @Optional @SerialName("custom_steps") var steps: String? = null,
        @Optional @SerialName("custom_steps_separated") var stepsSeparated: String? = null,
        @Optional @SerialName("custom_mission") var mission: String? = null,
        @Optional @SerialName("custom_goals") var goals: String? = null
)
{
    @Optional @SerialName("created_on") private val createdOnActual: Long? = createdOn.toString().toLongOrNull()
    @Optional @SerialName("updated_on") private val updatedOnActual: Long? = updatedOn.toString().toLongOrNull()
    @Optional @SerialName("estimate_forecast") private val estimateForecastActual: String? = estimateForecast.toString()
    @Optional @SerialName("estimate") private val estimateActual: String? = estimate.toString()

    init {
        if(createdOn == null) createdOn = Timestamp(createdOnActual)
        if(updatedOn == null) updatedOn = Timestamp(updatedOnActual)
        if(estimateForecast == null) estimateForecast = Timespan().parseTimespan(estimateForecastActual)
        if(estimate == null) estimate = Timespan().parseTimespan(estimateActual)
    }

    fun getCase(caseId: Int): Case
    {
        val endpoint = "get_case/$caseId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getCases
    (
        projectId: Int,
        suiteId: Int? = null,
        sectionId: Int? = null,
        createdAfter: Timestamp? = null,
        createdBefore: Timestamp? = null,
        createdBy: Array<Int>? = null,
        milestoneId: Array<Int>? = null,
        priorityId: Array<Int>? = null,
        templateId: Array<Int>? = null,
        typeId: Array<Int>? = null,
        updatedAfter: Timestamp? = null,
        updatedBefore: Timestamp? = null,
        updatedBy: Array<Int>? = null
    ): List<Case>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_cases/$projectId")
        if(suiteId != null) endpoint.append("&suite_id=$suiteId")
        if(sectionId != null) endpoint.append("&section_id=$sectionId")
        if(createdAfter != null) endpoint.append("&created_after=$createdAfter")
        if(createdBefore != null) endpoint.append("&created_before=$createdBefore")
        if(createdBy != null) endpoint.append("&created_by=$createdBy")
        if(milestoneId != null) endpoint.append("&milestone_id=$milestoneId")
        if(priorityId != null) endpoint.append("&priority_id=$priorityId")
        if(templateId != null) endpoint.append("&template_id=$templateId")
        if(typeId != null) endpoint.append("&type_id=$typeId")
        if(updatedAfter != null) endpoint.append("&updated_after=$updatedAfter")
        if(updatedBefore != null) endpoint.append("&updated_before=$updatedBefore")
        if(updatedBy != null) endpoint.append("&updated_by=$updatedBy")

        return JSON.unquoted.parse(Case.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun addCase(): Case
    {
        if(this.sectionId == null) throw MissingRequiredParamException("sectionId")
        val sectionId = this.sectionId
        val endpoint = "add_case/$sectionId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateCase(): Case
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val caseId = this.id
        val endpoint = "update_case/$caseId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deleteCase()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val caseId = this.id
        val endpoint = "delete_case/$caseId"
        Request().Post(endpoint)
    }
}