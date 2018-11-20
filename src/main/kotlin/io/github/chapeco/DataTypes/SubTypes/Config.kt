package io.github.chapeco.DataTypes.SubTypes

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Config
(
        @Optional var context: Context? = null,
        @Optional var options: Options? = null,
        @Optional var id: String? = null
)