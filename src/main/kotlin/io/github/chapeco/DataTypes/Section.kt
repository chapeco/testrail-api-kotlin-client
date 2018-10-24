package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
        return Section()
    }

    fun getSections(projectId: Int, suiteId: Int? = -1): Array<Section>
    {
        val suiteIdParam = if(suiteId == -1) "" else "&suite_id=$suiteId"
        val endpoint = "get_sections/$projectId$suiteIdParam"
        return Array<Section>(0) {Section()}
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