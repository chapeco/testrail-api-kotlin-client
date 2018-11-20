package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class CaseType
(
    //GET
    val id: Int? = null,
    @SerialName("is_default") val isDefault: Boolean? = null,
    val name: String? = null
)
{
    //TODO
    fun getCaseTypes(): List<CaseType>
    {
        val endpoint = "get_case_types"
        return JSON.unquoted.parse(CaseType.serializer().list, Request().Get(endpoint)!!)
    }
}