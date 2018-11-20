package io.github.chapeco.DataTypes.SubTypes

import kotlinx.serialization.Serializable

@Serializable
data class Step
(
        val content: String? = null,
        val expected: String? = null
)