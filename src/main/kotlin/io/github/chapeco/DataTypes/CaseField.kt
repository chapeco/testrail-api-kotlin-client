package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Type

data class CaseField
(
    //Read Only
    val id: Int? = null,
    val systemName: String? = null,
    val entityId: Int? = null,
    val typeId: Int? = null,
    val locationId: Int? = null,
    val displayOrder: Int? = null,
    val isMulti: Boolean? = null,
    val isActive: Boolean? = null,
    val statusId: Int? = null,
    val isSystem: Boolean? = null,

    //Read/Write
    var type: Type? = null,
    var name: String? = null,
    var label: String? = null,
    var description: String? = null,
    var includeAll: Boolean? = null,
    var templateIds: Array<Int>? = null,
    var configs: Array<Configuration>? = null
)
{

}