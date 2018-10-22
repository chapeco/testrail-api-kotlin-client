package io.github.chapeco.DataTypes

import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

data class ResultField
(
    val configs: Array<Configuration>? = null,
    val description: String? = null,
    val displayOrder: Int? = null,
    val id: Int? = null,
    val label: String? = null,
    val name: String? = null,
    val systemName: String? = null,
    val typeId: Int? = null
)