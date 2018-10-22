package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timespan
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result
(
    //GET
    @SerialName("created_by")
    val createdBy: Int? = null,
    @SerialName("created_on")
    val createdOn: Timestamp? = null,
    val id: Int? = null,
    @SerialName("test_id")
    val testId: Int? = null,

    //ADD
    @SerialName("status_id")
    var statusId: Int? = null,
    var comment: String? = null,
    var version: String? = null,
    var elapsed: Timespan? = null,
    var defects: String? = null,
    @SerialName("assignedto_id")
    var assignedToId: Int? = null
)