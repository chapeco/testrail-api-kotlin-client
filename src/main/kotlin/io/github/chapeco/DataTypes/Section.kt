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
        return Section()
    }

    fun getSections(projectId: Int, suiteId: Int): Array<Section>
    {
        return Array<Section>(0) {Section()}
    }

    fun addSection(projectId: Int): Section
    {
        return Section()
    }

    fun updateSection(sectionId: Int): Section
    {
        return Section()
    }

    fun deleteSection(sectionId: Int)
    {

    }
}