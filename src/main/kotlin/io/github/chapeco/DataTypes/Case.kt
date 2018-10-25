package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Case
(
    @SerialName("created_by") val createdBy: Int? = null,
    @SerialName("created_on") val createdOn: Timestamp? = null,
    @SerialName("estimate_forecast") val estimateForecast: Timespan? = null,
    val id: Int? = null,
    @SerialName("section_id") val sectionId: Int? = null,
    @SerialName("suite_id") val suiteId: Int? = null,
    @SerialName("updated_by") val updatedBy: Int? = null,
    @SerialName("updated_on") val updatedOn: Timestamp? = null,

    var title: String? = null,
    @SerialName("template_id") var templateId: Int? = null,
    @SerialName("type_id") var typeId: Int? = null,
    @SerialName("priority_id") var priorityId: Int? = null,
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
    ): Array<Case>
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