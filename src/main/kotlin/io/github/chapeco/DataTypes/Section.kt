package io.github.chapeco.DataTypes

data class Section
(
    val depth: Int? = null,
    val displayOrder: Int? = null,
    val id: Int? = null,

    var description: String? = null,
    var suiteId: Int? = null,
    var parentId: Int? = null,
    var name: String? = null
)
{}