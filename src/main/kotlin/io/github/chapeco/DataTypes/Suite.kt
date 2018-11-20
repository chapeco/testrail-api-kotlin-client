package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Suite
(
    //GET
        @Transient var completedOn: Timestamp? = null,
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
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
    }

    //TODO
    fun getSuite(suiteId: Int): Suite
    {
        val endpoint = "get_suite/$suiteId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getSuites(projectId: Int): List<Suite>
    {
        val endpoint = "get_suites/$projectId"
        return JSON.unquoted.parse(Suite.serializer().list, Request().Get(endpoint)!!)
    }

    fun addSuite(projectId: Int): Suite
    {
        val endpoint = "add_suite/$projectId"
        return Suite()
    }

    fun updateSuite(suiteId: Int): Suite
    {
        val endpoint = "update_suite/$suiteId"
        return Suite()
    }

    fun deleteSuite(suiteId: Int)
    {
        val endpoint = "delete_suite/$suiteId"

    }
}