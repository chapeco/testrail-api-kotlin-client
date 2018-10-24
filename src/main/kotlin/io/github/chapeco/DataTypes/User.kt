package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
        return User()
    }

    fun getUserByEmail(email: String): User
    {
        val endpoint = "get_user_by_email&email=$email"
        return User()
    }

    fun getUsers(): Array<User>
    {
        val endpoint = "get_users"
        return Array<User>(0) {User()}
    }
}