package io.github.chapeco.DataTypes.SubTypes

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Options
(
    @Optional @SerialName("is_required") var isRequired: Boolean? = null,
    @Optional var format: String? = null,
    @Optional @SerialName("has_expected") var hasExpected: Boolean? = null,
    @Optional @SerialName("has_actual") var hasActual: Boolean? = null,
    @Optional var rows: Int? = null
)