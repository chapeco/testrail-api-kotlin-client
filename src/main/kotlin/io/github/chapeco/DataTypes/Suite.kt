package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

/**
 * Serializable data class for the TestRail Suite DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-suites
 */
@Serializable
data class Suite
(
        @Transient var completedOn: Timestamp? = null,
        @Optional val id: Int? = null,
        @Optional @SerialName("is_baseline") val isBaseline: Boolean? = null,
        @Optional @SerialName("is_completed") val isCompleted: Boolean? = null,
        @Optional @SerialName("is_master") val isMaster: Boolean? = null,
        @Optional @SerialName("project_id") val projectId: Int? = null,
        @Optional val url: String? = null,
        @Optional var name: String? = null,
        @Optional var description: String? = null
)
{
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
    }

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

    fun addSuite(): Suite
    {
        if(this.projectId == null) throw MissingRequiredParamException("projectId")
        val projectId = this.projectId
        val endpoint = "add_suite/$projectId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateSuite(): Suite
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val suiteId = this.id
        val endpoint = "update_suite/$suiteId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deleteSuite()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val suiteId = this.id
        val endpoint = "delete_suite/$suiteId"
        Request().Post(endpoint)
    }
}