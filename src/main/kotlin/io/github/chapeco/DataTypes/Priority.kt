package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

/**
 * Serializable data class for the TestRail Priority DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-priorities
 */
@Serializable
data class Priority
(
        @Optional val id: Int? = null,
        @Optional @SerialName("is_default") val isDefault: Boolean? = null,
        @Optional val name: String? = null,
        @Optional val priority: Int? = null,
        @Optional @SerialName("short_name") val shortName: String? = null
)
{
    fun getPriorities(): List<Priority>
    {
        val endpoint = "get_priorities"
        return JSON.unquoted.parse(Priority.serializer().list, Request().Get(endpoint)!!)
    }
}