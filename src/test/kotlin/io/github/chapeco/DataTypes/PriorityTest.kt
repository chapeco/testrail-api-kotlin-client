package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

class PriorityTest
{
    @Test
    fun instantiatePriorityTest()
    {
        val expectedPriority = Priority(
                id = 1,
                isDefault = true,
                name = "some name",
                priority = 1,
                shortName = "some short name"
        )
        val actualPriority = Priority(
                id = 1,
                isDefault = true,
                name = "some name",
                priority = 1,
                shortName = "some short name"
        )
        Assert.assertEquals(expectedPriority,actualPriority)
    }

    @Test
    fun serializePriorityTest()
    {
        val expectedPriority: String = "{id:1,is_default:true,name:\"some name\",priority:1,short_name:\"some short name\"}"
        val actualPriority = Priority(
                id = 1,
                isDefault = true,
                name = "some name",
                priority = 1,
                shortName = "some short name"
        )
        println(JSON.unquoted.stringify(actualPriority))
        Assert.assertEquals(expectedPriority,JSON.unquoted.stringify(actualPriority))
    }

    @Test
    fun deserializePriorityTest()
    {
        val expectedPriority = Priority(
                id = 1,
                isDefault = true,
                name = "some name",
                priority = 1,
                shortName = "some short name"
        )
        Assert.assertEquals(expectedPriority,JSON.unquoted.parse<Priority>("{id:1,is_default:true,name:\"some name\",priority:1,short_name:\"some short name\"}"))
    }

    @Test
    fun getPrioritiesTest()
    {
        val expectedPrioritiesList = listOf(
                Priority(1,false,"Low",1,"Low"),
                Priority(2,true,"Medium",2,"Medium"),
                Priority(3,false,"High",3,"High"),
                Priority(4,false,"Critical",4,"Critical")
        )
        val actualPrioritiesList = Priority().getPriorities()
        println(JSON.unquoted.stringify(Priority.serializer().list,actualPrioritiesList))
        Assert.assertEquals(expectedPrioritiesList,actualPrioritiesList)
    }
}