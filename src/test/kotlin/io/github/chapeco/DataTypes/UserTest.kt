package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserTest()
{
    @Test
    fun instantiateUserTest()
    {
        val expectedUser = User(
                email = "some email",
                id = 1,
                isActive = true,
                name = "some name"
        )
        val actualUser = User(
                email = "some email",
                id = 1,
                isActive = true,
                name = "some name"
        )
        Assertions.assertEquals(expectedUser,actualUser)
    }

    @Test
    fun serializeUserTest()
    {
        val expectedUser: String = "{email:\"some email\",id:1,is_active:true,name:\"some name\"}"
        val actualUser = User(
                email = "some email",
                id = 1,
                isActive = true,
                name = "some name"
        )
        println(JSON.unquoted.stringify(actualUser))
        Assertions.assertEquals(expectedUser,JSON.unquoted.stringify(actualUser))
    }

    @Test
    fun deserializeUserTest()
    {
        val expectedUser = User(
                email = "some email",
                id = 1,
                isActive = true,
                name = "some name"
        )
        Assertions.assertEquals(expectedUser,JSON.unquoted.parse<User>("{email:\"some email\",id:1,is_active:true,name:\"some name\"}"))
    }

    @Test
    fun getUserTest()
    {

    }

    @Test
    fun getUserByEmailTest()
    {

    }

    @Test
    fun getUsersTest()
    {

    }
}