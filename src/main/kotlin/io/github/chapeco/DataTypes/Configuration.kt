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
        val endpoint = "get_configs/"
        return Array<Configuration>(0) {Configuration()}
    }

    fun addConfigGroup(projectId: Int)
    {
        val endpoint = "add_config_group/"
    }

    fun addConfig(configGroupId: Int)
    {
        val endpoint = "add_config/"
    }

    fun updateConfigGroup(configGroupId: Int)
    {
        val endpoint = "update_config_group/"
    }

    fun updateConfig(configId: Int)
    {
        val endpoint = "update_config/"
    }

    fun deleteConfigGroup(configGroupId: Int)
    {
        val endpoint = "delete_config_group/"
    }

    fun deleteConfig(configId: Int)
    {
        val endpoint = "delete_config/"
    }
}