package io.github.chapeco.DataTypes

import io.github.chapeco.DataTypes.SubTypes.Config
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Type
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class CaseField
(
    //GET
        @Optional val id: Int? = null,
        @Optional @SerialName("system_name") val systemName: String? = null,
        @Optional @SerialName("entity_id") val entityId: Int? = null,
        @Optional @SerialName("type_id") val typeId: Int? = null,
        @Optional @SerialName("location_id") val locationId: Int? = null,
        @Optional @SerialName("display_order") val displayOrder: Int? = null,
        @Optional @SerialName("is_multi") val isMulti: Boolean? = null,
        @Optional @SerialName("is_active") val isActive: Boolean? = null,
        @Optional @SerialName("status_id") val statusId: Int? = null,
        @Optional @SerialName("is_system") val isSystem: Boolean? = null,

    //ADD/UPDATE
        @Optional var type: Type? = null,
        @Optional var name: String? = null,
        @Optional var label: String? = null,
        @Optional var description: String? = null,
        @Optional @SerialName("include_all") var includeAll: Boolean? = null,
        @Optional @SerialName("template_ids") var templateIds: List<Int>? = null,
        @Optional var configs: List<Config>? = null
)
{
    //TODO
    fun getCaseFields(): List<CaseField>
    {
        val endpoint = "get_case_fields/"
        return JSON.unquoted.parse(CaseField.serializer().list, Request().Get(endpoint)!!)
    }

    fun addCaseField(): CaseField
    {
        val endpoint = "add_case_field/"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }
}