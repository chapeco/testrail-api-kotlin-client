package io.github.chapeco.DataTypes

import io.github.chapeco.DataTypes.SubTypes.Config
import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class ResultField
(
    //GET
        val configs: List<Config>? = null,
        val description: String? = null,
        @SerialName("display_order") val displayOrder: Int? = null,
        val id: Int? = null,
        val label: String? = null,
        val name: String? = null,
        @SerialName("system_name") val systemName: String? = null,
        @SerialName("type_id") val typeId: Int? = null,
        @SerialName("is_active") var isActive: Boolean? = null,
        @SerialName("include_all") var includeAll: Boolean? = null,
        @SerialName("template_ids") var templateIds: List<Int>? = null
)
{
    //TODO
    fun getResultFields(): List<ResultField>
    {
        val endpoint = "get_result_fields"
        return JSON.unquoted.parse(ResultField.serializer().list, Request().Get(endpoint)!!)
    }
}