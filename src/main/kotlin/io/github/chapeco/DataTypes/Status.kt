package io.github.chapeco.DataTypes

data class Status
(
    val colorBright: Long? = null,
    val colorDark: Long? = null,
    val colorMedium: Long? = null,
    val id: Int? = null,
    val isFinal: Boolean? = null,
    val isSystem: Boolean? = null,
    val isUntested: Boolean? = null,
    val label: String? = null,
    val name: String? = null
)