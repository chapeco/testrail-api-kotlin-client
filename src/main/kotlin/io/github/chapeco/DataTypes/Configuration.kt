package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Configuration
(
    //GET
    @SerialName("group_id") val groupId: Int? = null,
    val id: Int? = null,

    //ADD/UPDATE
    var name: String? = null
)
{
    //TODO
    fun getConfigs(projectId: Int): Array<Configuration>
    {
        return Array<Configuration>(0) {Configuration()}
    }

    fun addConfigGroup(projectId: Int)
    {

    }

    fun addConfig(configGroupId: Int)
    {

    }

    fun updateConfigGroup(configGroupId: Int)
    {

    }

    fun updateConfig(configId: Int)
    {

    }

    fun deleteConfigGroup(configGroupId: Int)
    {

    }

    fun deleteConfig(configId: Int)
    {

    }
}