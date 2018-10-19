package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan

data class Case(var title: String? = null,
                var templateId: Int? = null,
                var typeId: Int? = null,
                var priorityId: Int? = null,
                var estimate: Timespan? = null,
                var milestoneId: Int? = null,
                var refs: String? = null)