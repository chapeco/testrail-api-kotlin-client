package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class Section
(
    val depth: Int? = null,
    @SerialName("display_order") val displayOrder: Int? = null,
    val id: Int? = null,

    var description: String? = null,
    @SerialName("suite_id") var suiteId: Int? = null,
    @SerialName("parent_id") var parentId: Int? = null,
    var name: String? = null
)
{
    //TODO
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

    fun addSection(projectId: Int): Section
    {
        val endpoint = "add_section/$projectId"
        return Section()
    }

    fun updateSection(sectionId: Int): Section
    {
        val endpoint = "update_section/$sectionId"
        return Section()
    }

    fun deleteSection(sectionId: Int)
    {
        val endpoint = "delete_section/$sectionId"

    }
}