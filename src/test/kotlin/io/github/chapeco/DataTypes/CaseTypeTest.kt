package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CaseTypeTest
{
    @Test
    fun instantiateCaseTypeTest()
    {
        val expectedCaseType = CaseType(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        val actualCaseType = CaseType(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        Assertions.assertEquals(expectedCaseType,actualCaseType)
    }

    @Test
    fun serializeCaseTypeTest()
    {
        val expectedCaseType: String = "{id:1,is_default:true,name:\"some name\"}"
        val actualCaseType = CaseType(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        println(JSON.unquoted.stringify(actualCaseType))
        Assertions.assertEquals(expectedCaseType,JSON.unquoted.stringify(actualCaseType))
    }

    @Test
    fun deserializeCaseTypeTest()
    {
        val expectedCaseType = CaseType(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        Assertions.assertEquals(expectedCaseType,JSON.unquoted.parse<CaseType>("{id:1,is_default:true,name:\"some name\"}"))
    }

    @Test
    fun getCaseTypesTest()
    {

    }
}