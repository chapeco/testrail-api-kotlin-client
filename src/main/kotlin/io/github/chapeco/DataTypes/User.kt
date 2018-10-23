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
        return User()
    }

    fun getUserByEmail(email: String): User
    {
        return User()
    }

    fun getUsers(): Array<User>
    {
        return Array<User>(0) {User()}
    }
}