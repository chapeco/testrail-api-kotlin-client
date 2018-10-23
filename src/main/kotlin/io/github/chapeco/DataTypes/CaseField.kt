package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CaseField
(
    //GET
    val id: Int? = null,
    @SerialName("system_name") val systemName: String? = null,
    @SerialName("entity_id") val entityId: Int? = null,
    @SerialName("type_id")
    val typeId: Int? = null,
    @SerialName("location_id") val locationId: Int? = null,
    @SerialName("display_order") val displayOrder: Int? = null,
    @SerialName("is_multi") val isMulti: Boolean? = null,
    @SerialName("is_active") val isActive: Boolean? = null,
    @SerialName("status_id") val statusId: Int? = null,
    @SerialName("is_system") val isSystem: Boolean? = null,

    //ADD/UPDATE
    var type: Type? = null,
    var name: String? = null,
    var label: String? = null,
    var description: String? = null,
    @SerialName("include_all") var includeAll: Boolean? = null,
    @SerialName("template_ids") var templateIds: Array<Int>? = null,
    var configs: Array<Configuration>? = null
)
{
    //TODO
    fun getCaseFields(): Array<CaseField>
    {
        return Array<CaseField>(0) {CaseField()}
    }

    fun addCaseField(): CaseField
    {
        return CaseField()
    }
}