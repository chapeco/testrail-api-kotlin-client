package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

/**
 * Serializable data class for the TestRail Section DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-sections
 */
@Serializable
data class Section
(
        @Optional val depth: Int? = null,
        @Optional @SerialName("display_order") val displayOrder: Int? = null,
        @Optional val id: Int? = null,
        @Transient val projectId: Int? = null,
        @Optional var description: String? = null,
        @Optional @SerialName("suite_id") var suiteId: Int? = null,
        @Optional @SerialName("parent_id") var parentId: Int? = null,
        @Optional var name: String? = null
)
{
    fun getSection(sectionId: Int): Section
    {
        val endpoint = "get_section/$sectionId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getSections(projectId: Int, suiteId: Int? = null): List<Section>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_sections/$projectId")
        if(suiteId != null) endpoint.append("&suite_id=$suiteId")
        return JSON.unquoted.parse(Section.serializer().list, Request().Get(endpoint.toString())!!)
    }

    fun addSection(): Section
    {
        if(this.projectId == null) throw MissingRequiredParamException("projectId")
        val projectId = this.projectId
        val endpoint = "add_section/$projectId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateSection(): Section
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val sectionId = this.id
        val endpoint = "update_section/$sectionId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deleteSection()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val sectionId = this.id
        val endpoint = "delete_section/$sectionId"
        Request().Post(endpoint)
    }
}