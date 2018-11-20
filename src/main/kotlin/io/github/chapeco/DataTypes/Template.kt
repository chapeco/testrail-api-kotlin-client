package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class Template
(
    val id: Int? = null,
    @SerialName("is_default") val isDefault: Boolean? = null,
    val name: String? = null
)
{
    //TODO
    fun getTemplates(projectId: Int): List<Template>
    {
        val endpoint = "get_templates/$projectId"
        return JSON.unquoted.parse(Template.serializer().list, Request().Get(endpoint)!!)
    }
}