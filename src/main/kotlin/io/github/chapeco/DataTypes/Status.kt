package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status
(
    //GET
    @SerialName("color_bright")
    val colorBright: Long? = null,
    @SerialName("color_dark")
    val colorDark: Long? = null,
    @SerialName("color_medium")
    val colorMedium: Long? = null,
    val id: Int? = null,
    @SerialName("is_final")
    val isFinal: Boolean? = null,
    @SerialName("is_system")
    val isSystem: Boolean? = null,
    @SerialName("is_untested")
    val isUntested: Boolean? = null,
    val label: String? = null,
    val name: String? = null
)