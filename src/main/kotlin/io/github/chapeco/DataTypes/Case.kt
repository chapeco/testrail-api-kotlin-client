package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan

data class Case
(
    //Read Only
    val createdBy: Int? = null,
    val createdOn: Timespan? = null,
    val estimateForecast: Timespan? = null,
    val id: Int? = null,
    val sectionId: Int? = null,
    val suiteId: Int? = null,
    val updatedBy: Int? = null,
    val updatedOn: Int? = null,

    //Read/Write
    var title: String? = null,
    var templateId: Int? = null,
    var typeId: Int? = null,
    var priorityId: Int? = null,
    var estimate: Timespan? = null,
    var milestoneId: Int? = null,
    var refs: String? = null
)