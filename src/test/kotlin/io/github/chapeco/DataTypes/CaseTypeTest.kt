package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

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
        Assert.assertEquals(expectedCaseType,actualCaseType)
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
        Assert.assertEquals(expectedCaseType,JSON.unquoted.stringify(actualCaseType))
    }

    @Test
    fun deserializeCaseTypeTest()
    {
        val expectedCaseType = CaseType(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        Assert.assertEquals(expectedCaseType,JSON.unquoted.parse<CaseType>("{id:1,is_default:true,name:\"some name\"}"))
    }

    @Test
    fun getCaseTypesTest()
    {
        val expectedCaseTypeList = listOf(
                CaseType(1,false,"Acceptance"),
                CaseType(2,false,"Accessibility"),
                CaseType(3,false,"Automated"),
                CaseType(4,false,"Compatibility"),
                CaseType(5,false,"Destructive"),
                CaseType(6,false,"Functional"),
                CaseType(7,true,"Other"),
                CaseType(8,false,"Performance"),
                CaseType(9,false,"Regression"),
                CaseType(10,false,"Security"),
                CaseType(11,false,"Smoke & Sanity"),
                CaseType(12,false,"Usability")
        )
        val actualCaseTypeList = CaseType().getCaseTypes()
        println(JSON.unquoted.stringify(CaseType.serializer().list,actualCaseTypeList))
        Assert.assertEquals(expectedCaseTypeList,actualCaseTypeList)
    }
}