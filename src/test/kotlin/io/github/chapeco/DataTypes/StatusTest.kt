package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StatusTest
{
    @Test
    fun instantiateStatusTest()
    {
        val expectedStatus = Status(
                colorBright = 1,
                colorDark = 1,
                colorMedium = 1,
                id = 1,
                isFinal = true,
                isSystem = true,
                isUntested = true,
                label = "some string",
                name = "some name"
        )
        val actualStatus = Status(
                colorBright = 1,
                colorDark = 1,
                colorMedium = 1,
                id = 1,
                isFinal = true,
                isSystem = true,
                isUntested = true,
                label = "some string",
                name = "some name"
        )
        Assertions.assertEquals(expectedStatus,actualStatus)
    }

    @Test
    fun serializeStatusTest()
    {
        val expectedStatus: String = "{color_bright:1,color_dark:1,color_medium:1,id:1,is_final:true,is_system:true,is_untested:true,label:\"some string\",name:\"some name\"}"
        val actualStatus = Status(
                colorBright = 1,
                colorDark = 1,
                colorMedium = 1,
                id = 1,
                isFinal = true,
                isSystem = true,
                isUntested = true,
                label = "some string",
                name = "some name"
        )
        println(JSON.unquoted.stringify(actualStatus))
        Assertions.assertEquals(expectedStatus,JSON.unquoted.stringify(actualStatus))
    }

    @Test
    fun deserializeStatusTest()
    {
        val expectedStatus = Status(
                colorBright = 1,
                colorDark = 1,
                colorMedium = 1,
                id = 1,
                isFinal = true,
                isSystem = true,
                isUntested = true,
                label = "some string",
                name = "some name"
        )
        Assertions.assertEquals(expectedStatus,JSON.unquoted.parse<Status>("{color_bright:1,color_dark:1,color_medium:1,id:1,is_final:true,is_system:true,is_untested:true,label:\"some string\",name:\"some name\"}"))
    }

    @Test
    fun getStatusesTest()
    {

    }
}