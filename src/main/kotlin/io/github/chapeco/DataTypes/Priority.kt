package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    fun getPriorities(): Array<Priority>
    {
        val endpoint = "get_priorities"
        return Array<Priority>(0) {Priority()}
    }
}