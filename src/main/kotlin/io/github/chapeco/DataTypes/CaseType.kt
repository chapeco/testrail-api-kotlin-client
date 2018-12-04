package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

/**
 * Serializable data class for the TestRail CaseType DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-cases-types
 */
@Serializable
data class CaseType
(
    @Optional val id: Int? = null,
    @Optional @SerialName("is_default") val isDefault: Boolean? = null,
    @Optional val name: String? = null
)
{
    fun getCaseTypes(): List<CaseType>
    {
        val endpoint = "get_case_types"
        return JSON.unquoted.parse(CaseType.serializer().list, Request().Get(endpoint)!!)
    }
}