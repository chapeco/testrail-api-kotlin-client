package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

@Serializable
data class User
(
    val email: String? = null,
    val id: Int? = null,
    @SerialName("is_active") val isActive: Boolean? = null,
    val name: String? = null
)
{
    //TODO
    fun getUser(userId: Int): User
    {
        val endpoint = "get_user/$userId"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getUserByEmail(email: String): User
    {
        val endpoint = "get_user_by_email&email=$email"
        return JSON.unquoted.parse(Request().Get(endpoint)!!)
    }

    fun getUsers(): List<User>
    {
        val endpoint = "get_users"
        return JSON.unquoted.parse(User.serializer().list, Request().Get(endpoint)!!)
    }
}