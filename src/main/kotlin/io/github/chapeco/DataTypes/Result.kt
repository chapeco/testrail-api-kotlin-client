package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp

data class Result
(
    //Read Only
    val createdBy: Int? = null,
    val createdOn: Timestamp? = null,
    val id: Int? = null,
    val testId: Int? = null,

    //Read/Write
    var statusId: Int? = null,
    var comment: String? = null,
    var version: String? = null,
    var elapsed: Timespan? = null,
    var defects: String? = null,
    var assignedToId: Int? = null
)
{

}