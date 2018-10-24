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

    fun getCases
    (
        projectId: Int,
        suiteId: Int? = -1,
        sectionId: Int? = -1,
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
        val suiteIdParam = if(suiteId == -1) "" else "&suite_id=$suiteId"
        val sectionIdParam = if(sectionId == -1) "" else "&section_id=$sectionId"
        val createdAfterParam = if(createdAfter == null) "" else "&created_after=$createdAfter"
        val createdBeforeParam = if(createdBefore == null) "" else "&created_before=$createdBefore"
        val createdByParam = if(createdBy == null) "" else "&created_by=$createdBy"
        val milestoneIdParam = if(milestoneId == null) "" else "&milestone_id=$milestoneId"
        val priorityIdParam = if(priorityId == null) "" else "&priority_id=$priorityId"
        val templateIdParam = if(templateId == null) "" else "&template_id=$templateId"
        val typeIdParam = if(typeId == null) "" else "&type_id=$typeId"
        val updatedAfterParam = if(updatedAfter == null) "" else "&updated_after=$updatedAfter"
        val updatedBeforeParam = if(updatedBefore == null) "" else "&updated_before=$updatedBefore"
        val updatedByParam = if(updatedBy == null) "" else "&updated_by=$updatedBy"
        val endpoint = "get_cases/$projectId" +
                suiteIdParam +
                sectionIdParam +
                createdAfterParam +
                createdBeforeParam +
                createdByParam +
                milestoneIdParam +
                priorityIdParam +
                templateIdParam +
                typeIdParam +
                updatedAfterParam +
                updatedBeforeParam +
                updatedByParam

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