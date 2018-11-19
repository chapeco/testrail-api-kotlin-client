package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class Status
(
    //GET
    @SerialName("color_bright") val colorBright: Long? = null,
    @SerialName("color_dark") val colorDark: Long? = null,
    @SerialName("color_medium") val colorMedium: Long? = null,
    val id: Int? = null,
    @SerialName("is_final") val isFinal: Boolean? = null,
    @SerialName("is_system") val isSystem: Boolean? = null,
    @SerialName("is_untested") val isUntested: Boolean? = null,
    val label: String? = null,
    val name: String? = null
)
{
    //TODO
    fun getStatuses(): List<Status>
    {
        val endpoint = "get_statuses"
        return JSON.unquoted.parse(Status.serializer().list, Request().Get(endpoint)!!)
    }
}