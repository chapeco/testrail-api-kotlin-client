package io.github.chapeco.DataTypes.SubTypes

import io.github.chapeco.DataTypes.Result
import kotlinx.serialization.Serializable

@Serializable
data class Results(
        val results: List<Result>? = null
)