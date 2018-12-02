package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class Configuration
(
        @Optional @SerialName("project_id") val projectId: Int? = null,
        @Optional @SerialName("group_id") val groupId: Int? = null,
        @Optional val configs: List<Configuration>? = null,
        @Optional val id: Int? = null,
        @Optional var name: String? = null
)
{
    //TODO
    fun getConfigs(projectId: Int): List<Configuration>
    {
        val endpoint = "get_configs/$projectId"
        return JSON.unquoted.parse(Configuration.serializer().list, Request().Get(endpoint)!!)
    }

    fun addConfigGroup(): Configuration
    {
        if(this.projectId == null) throw MissingRequiredParamException("projectId")
        if(this.name == null) throw MissingRequiredParamException("name")
        val projectId = this.projectId
        val endpoint = "add_config_group/$projectId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun addConfig(): Configuration
    {
        if(this.name == null) throw MissingRequiredParamException("name")
        val configGroupId = this.groupId
        val endpoint = "add_config/$configGroupId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateConfigGroup(): Configuration
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val configGroupId = this.id
        val endpoint = "update_config_group/$configGroupId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateConfig(): Configuration
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val configId = this.id
        val endpoint = "update_config/$configId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deleteConfigGroup()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val configGroupId = this.id
        val endpoint = "delete_config_group/$configGroupId"
        Request().Post(endpoint)
    }

    fun deleteConfig()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val configId = this.id
        val endpoint = "delete_config/$configId"
        Request().Post(endpoint)
    }
}