package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Suite
(
    //GET
    @SerialName("completed_on") val completedOn: Timestamp? = null,
    val id: Int? = null,
    @SerialName("is_baseline") val isBaseline: Boolean? = null,
    @SerialName("is_completed") val isCompleted: Boolean? = null,
    @SerialName("is_master") val isMaster: Boolean? = null,
    @SerialName("project_id") val projectId: Int? = null,
    val url: String? = null,

    //ADD/UPDATE
    var name: String? = null,
    var description: String? = null
)
{
    //TODO
    fun getSuite(suiteId: Int): Suite
    {
        return Suite()
    }

    fun getSuites(projectId: Int): Array<Suite>
    {
        return Array<Suite>(0) {Suite()}
    }

    fun addSuite(projectId: Int): Suite
    {
        return Suite()
    }

    fun updateSuite(suiteId: Int): Suite
    {
        return Suite()
    }

    fun deleteSuite(suiteId: Int)
    {

    }
}