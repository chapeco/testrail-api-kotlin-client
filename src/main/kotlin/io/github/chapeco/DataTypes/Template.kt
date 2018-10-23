package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Template
(
    val id: Int? = null,
    @SerialName("is_default") val isDefault: Boolean? = null,
    val name: String? = null
)
{
    //TODO
    fun getTemplates(projectId: Int): Array<Template>
    {
        return Array<Template>(0) {Template()}
    }
}