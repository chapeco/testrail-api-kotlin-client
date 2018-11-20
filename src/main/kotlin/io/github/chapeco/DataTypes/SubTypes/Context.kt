package io.github.chapeco.DataTypes.SubTypes

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Context
(
    @Optional @SerialName("is_global") var isGlobal: Boolean? = null,
    @Optional @SerialName("project_ids") var projectIds: List<Int>? = null
)