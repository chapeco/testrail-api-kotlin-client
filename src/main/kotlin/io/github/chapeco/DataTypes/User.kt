package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

/**
 * Serializable data class for the TestRail User DataType
 *
 * See: http://docs.gurock.com/testrail-api2/reference-users
 */
@Serializable
data class User
(
    @Optional val email: String? = null,
    @Optional val id: Int? = null,
    @Optional @SerialName("is_active") val isActive: Boolean? = null,
    @Optional val name: String? = null
)
{
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