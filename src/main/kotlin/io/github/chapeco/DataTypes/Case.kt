package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Case
(
    //GET
    @SerialName("created_by") val createdBy: Int? = null,
    @SerialName("created_on") val createdOn: Timestamp? = null,
    @SerialName("estimate_forecast") val estimateForecast: Timespan? = null,
    val id: Int? = null,
    @SerialName("section_id") val sectionId: Int? = null,
    @SerialName("suite_id") val suiteId: Int? = null,
    @SerialName("updated_by") val updatedBy: Int? = null,
    @SerialName("updated_on") val updatedOn: Timestamp? = null,

    //ADD/UPDATE
    var title: String? = null,
    @SerialName("template_id") var templateId: Int? = null,
    @SerialName("type_id") var typeId: Int? = null,
    @SerialName("priority_id")
    var priorityId: Int? = null,
    var estimate: Timespan? = null,
    @SerialName("milestone_id") var milestoneId: Int? = null,
    var refs: String? = null
)
{
    //TODO
    fun getCase(caseId: Int): Case
    {
        val endpoint = "get_case/$caseId"
        return Case()
    }

    fun getCases(projectId: Int, suiteId: Int? = -1, sectionId: Int? = -1): Array<Case>
    {
        val suiteIdParam = if(suiteId == -1) "" else "&suite_id=$suiteId"
        val sectionIdParam = if(sectionId == -1) "" else "&section_id=$sectionId"
        val endpoint = "get_cases/$projectId$suiteIdParam$sectionIdParam"

        return Array<Case>(0) {Case()}
    }

    fun addCase(sectionId: Int): Case
    {
        val endpoint = "add_case/$sectionId"
        return Case()
    }

    fun updateCase(caseId: Int): Case
    {
        val endpoint = "update_case/$caseId"
        return Case()
    }

    fun deleteCase(caseId: Int)
    {
        val endpoint = "delete_case/$caseId"
    }
}