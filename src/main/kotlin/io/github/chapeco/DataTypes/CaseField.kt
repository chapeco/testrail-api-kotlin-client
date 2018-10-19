package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Type

data class CaseField(
    var type: Type? = null,
    var name: String? = null,
    var label: String? = null,
    var description: String? = null,
    var includeAll: Boolean? = null,
    var templateIds: Array<Int>? = null,
    var configs: Array<Configuration>? = null)
{

}