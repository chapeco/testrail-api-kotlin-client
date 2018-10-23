package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultField
(
    //GET
    val configs: Array<Configuration>? = null,
    val description: String? = null,
    @SerialName("display_order") val displayOrder: Int? = null,
    val id: Int? = null,
    val label: String? = null,
    val name: String? = null,
    @SerialName("system_name") val systemName: String? = null,
    @SerialName("type_id") val typeId: Int? = null
)
{
    //TODO
    fun getResultFields(): Array<ResultField>
    {
        return Array<ResultField>(0) {ResultField()}
    }
}