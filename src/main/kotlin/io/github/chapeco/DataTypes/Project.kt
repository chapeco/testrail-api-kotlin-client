package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Project
(
    //GET
        val id: Int? = null,
        @Transient var completedOn: Timestamp? = null,
        val url: String? = null,

    //ADD/UPDATE
        var name: String? = null,
        var announcement: String? = null,
        @SerialName("show_announcement") var showAnnouncement: Boolean? = null,
        @SerialName("suite_mode") var suiteMode: Int? = null,

    //UPDATE
        @SerialName("is_completed") var isCompleted: Boolean? = null
)
{
    @Optional @SerialName("completed_on") val completedOnActual: Long? = completedOn.toString().toLongOrNull()

    init {
        if(completedOn == null) completedOn = Timestamp(completedOnActual)
    }

    //TODO
    fun getProject(projectId: Int): Project
    {
        val endpoint = "get_project/$projectId"
        return Project()
    }

    fun getProjects(isCompleted: Boolean? = null): Array<Project>
    {
        val endpoint = StringBuilder()
        endpoint.append("get_projects")
        if(isCompleted != null) endpoint.append("&is_completed=$isCompleted")

        return Array<Project>(0) {Project()}
    }

    fun addProject(): Project
    {
        val endpoint = "add_project"
        return Project()
    }

    fun updateProject(projectId: Int): Project
    {
        val endpoint = "update_project/$projectId"
        return Project()
    }

    fun deleteProject(projectId: Int)
    {
        val endpoint = "delete_project/$projectId"
    }
}