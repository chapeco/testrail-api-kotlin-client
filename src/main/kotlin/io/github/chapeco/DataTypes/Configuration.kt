package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Configuration
(
    //GET
    @SerialName("group_id")
    val groupId: Int? = null,
    val id: Int? = null,

    //ADD/UPDATE
    var name: String? = null
)
{

}