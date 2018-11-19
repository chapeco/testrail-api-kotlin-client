package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class Priority
(
    //GET
    val id: Int? = null,
    @SerialName("is_default") val isDefault: Boolean? = null,
    val name: String? = null,
    val priority: Int? = null,
    @SerialName("short_name") val shortName: String? = null
)
{
    //TODO
    fun getPriorities(): List<Priority>
    {
        val endpoint = "get_priorities"
        return JSON.unquoted.parse(Priority.serializer().list, Request().Get(endpoint)!!)
    }
}