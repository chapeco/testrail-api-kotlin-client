package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        Assertions.assertEquals(expectedPriority,actualPriority)
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
        Assertions.assertEquals(expectedPriority,JSON.unquoted.stringify(actualPriority))
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
        Assertions.assertEquals(expectedPriority,JSON.unquoted.parse<Priority>("{id:1,is_default:true,name:\"some name\",priority:1,short_name:\"some short name\"}"))
    }

    @Test
    fun getPrioritiesTest()
    {

    }
}