package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

/**
 * Serializable data class for the TestRail Status DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-statuses
 */
@Serializable
data class Status
(
        @Optional @SerialName("color_bright") val colorBright: Long? = null,
        @Optional @SerialName("color_dark") val colorDark: Long? = null,
        @Optional @SerialName("color_medium") val colorMedium: Long? = null,
        @Optional val id: Int? = null,
        @Optional @SerialName("is_final") val isFinal: Boolean? = null,
        @Optional @SerialName("is_system") val isSystem: Boolean? = null,
        @Optional @SerialName("is_untested") val isUntested: Boolean? = null,
        @Optional val label: String? = null,
        @Optional val name: String? = null
)
{
    fun getStatuses(): List<Status>
    {
        val endpoint = "get_statuses"
        return JSON.unquoted.parse(Status.serializer().list, Request().Get(endpoint)!!)
    }
}