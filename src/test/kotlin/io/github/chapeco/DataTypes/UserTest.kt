package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

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
        Assert.assertEquals(expectedUser,actualUser)
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
        Assert.assertEquals(expectedUser,JSON.unquoted.stringify(actualUser))
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
        Assert.assertEquals(expectedUser,JSON.unquoted.parse<User>("{email:\"some email\",id:1,is_active:true,name:\"some name\"}"))
    }

    @Test
    fun getUserTest()
    {
        val expectedUser = User(email = System.getProperty("testrailUsername"),id = 1,isActive = true, name = "David Parker")
        val actualUser = User().getUser(1)
        println(JSON.unquoted.stringify(actualUser))
        assertEquals(expectedUser,actualUser)
    }

    @Test
    fun getUserByEmailTest()
    {
        val expectedUser = User(email = System.getProperty("testrailUsername"),id = 1,isActive = true, name = "David Parker")
        val actualUser = User().getUserByEmail(System.getProperty("testrailUsername"))
        println(JSON.unquoted.stringify(actualUser))
        assertEquals(expectedUser,actualUser)
    }

    @Test
    fun getUsersTest()
    {
        val expectedUser = User(email = System.getProperty("testrailUsername"),id = 1,isActive = true, name = "David Parker")
        val expectedUserList = List<User>(1) {expectedUser}
        val actualUserList = User().getUsers()
        println(JSON.unquoted.stringify(User.serializer().list,actualUserList))
        assertEquals(expectedUserList,actualUserList)
    }
}