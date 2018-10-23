package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CaseType
(
    //GET
    val id: Int? = null,
    @SerialName("is_default") val isDefault: Boolean? = null,
    val name: String? = null
)
{
    //TODO
    fun getCaseTypes(): Array<CaseType>
    {
        return Array<CaseType>(0) {CaseType()}
    }
}