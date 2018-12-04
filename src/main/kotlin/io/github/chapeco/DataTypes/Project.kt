package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

/**
 * Serializable data class for the TestRail Project DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-projects
 */
@Serializable
data class Project
(
        @Optional val id: Int? = null,
        @Optional @Transient var completedOn: Timestamp? = null,
        @Optional val url: String? = null,
        @Optional var name: String? = null,
        @Optional var announcement: String? = null,
        @Optional @SerialName("show_announcement") var showAnnouncement: Boolean? = null,
        @Optional @SerialName("suite_mode") var suiteMode: Int? = null,
        @Optional @SerialName("is_completed") var isCompleted: Boolean? = null
)
{
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
    }

    fun getProject(projectId: Int): Project
    {
        val endpoint = "get_project/$projectId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getProjects(isCompleted: Boolean? = null): List<Project>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_projects")
        if(isCompleted != null) endpoint.append("&is_completed=$isCompleted")
        return JSON.unquoted.parse(Project.serializer().list,Request().Get(endpoint.toString())!!)
    }

    fun addProject(): Project
    {
        val endpoint = "add_project"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updateProject(): Project
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val projectId = this.id
        val endpoint = "update_project/$projectId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deleteProject()
    {
        if(this.id == null) throw MissingRequiredParamException("id")
        val projectId = this.id
        val endpoint = "delete_project/$projectId"
        Request().Post(endpoint)
    }
}