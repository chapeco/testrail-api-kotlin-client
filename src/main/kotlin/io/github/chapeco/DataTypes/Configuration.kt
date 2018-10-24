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
        val endpoint = "get_configs/$projectId"
        return Array<Configuration>(0) {Configuration()}
    }

    fun addConfigGroup(projectId: Int)
    {
        val endpoint = "add_config_group/$projectId"
    }

    fun addConfig(configGroupId: Int)
    {
        val endpoint = "add_config/$configGroupId"
    }

    fun updateConfigGroup(configGroupId: Int)
    {
        val endpoint = "update_config_group/$configGroupId"
    }

    fun updateConfig(configId: Int)
    {
        val endpoint = "update_config/$configId"
    }

    fun deleteConfigGroup(configGroupId: Int)
    {
        val endpoint = "delete_config_group/$configGroupId"
    }

    fun deleteConfig(configId: Int)
    {
        val endpoint = "delete_config/$configId"
    }
}