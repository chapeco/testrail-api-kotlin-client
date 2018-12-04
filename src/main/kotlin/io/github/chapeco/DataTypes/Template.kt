package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

/**
 * Serializable data class for the TestRail Template DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-templates
 */
@Serializable
data class Template
(
    @Optional val id: Int? = null,
    @Optional @SerialName("is_default") val isDefault: Boolean? = null,
    @Optional val name: String? = null
)
{
    fun getTemplates(projectId: Int): List<Template>
    {
        val endpoint = "get_templates/$projectId"
        return JSON.unquoted.parse(Template.serializer().list, Request().Get(endpoint)!!)
    }
}