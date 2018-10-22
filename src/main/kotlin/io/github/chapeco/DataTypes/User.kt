package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User
(
    val email: String? = null,
    val id: Int? = null,
    @SerialName("is_active")
    val isActive: Boolean? = null,
    val name: String? = null
)