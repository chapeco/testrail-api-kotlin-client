package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
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
        val expectedStatusesList = listOf(
                Status(
                        colorBright = 12709313,
                        colorDark = 6667107,
                        colorMedium = 9820525,
                        id = 1,
                        isFinal = true,
                        isSystem = true,
                        isUntested = false,
                        label = "Passed",
                        name = "passed"
                ),
                Status(
                        colorBright = 14737632,
                        colorDark = 9474192,
                        colorMedium = 13684944,
                        id = 2,
                        isFinal = true,
                        isSystem = true,
                        isUntested = false,
                        label = "Blocked",
                        name = "blocked"
                ),
                Status(
                        colorBright = 15790320,
                        colorDark = 11579568,
                        colorMedium = 15395562,
                        id = 3,
                        isFinal = false,
                        isSystem = true,
                        isUntested = true,
                        label = "Untested",
                        name = "untested"
                ),
                Status(
                        colorBright = 16448182,
                        colorDark = 13026868,
                        colorMedium = 15593088,
                        id = 4,
                        isFinal = false,
                        isSystem = true,
                        isUntested = false,
                        label = "Retest",
                        name = "retest"
                ),
                Status(
                        colorBright = 16631751,
                        colorDark = 14250867,
                        colorMedium = 15829135,
                        id = 5,
                        isFinal = true,
                        isSystem = true,
                        isUntested = false,
                        label = "Failed",
                        name = "failed"
                )
        )
        val actualStatusesList = Status().getStatuses()
        println(JSON.stringify(Status.serializer().list,actualStatusesList))
        Assertions.assertEquals(expectedStatusesList,actualStatusesList)
    }
}