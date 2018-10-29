package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ResultFieldTest
{
    @Test
    fun instantiateResultFieldTest()
    {
        val expectedResultField = ResultField(
                configs = Array<Configuration>(1) { Configuration() },
                description = "some description",
                displayOrder = 1,
                id = 1,
                label = "some label",
                name = "some name",
                systemName = "some system name",
                typeId = 1
        )
        val actualResultField = ResultField(
                configs = Array<Configuration>(1) { Configuration() },
                description = "some description",
                displayOrder = 1,
                id = 1,
                label = "some label",
                name = "some name",
                systemName = "some system name",
                typeId = 1
        )
        Assertions.assertEquals(expectedResultField.toString(),actualResultField.toString())
    }

    @Test
    fun serializeResultFieldTest()
    {
        val expectedResultField: String = "{configs:[{group_id:null,id:null,name:null}],description:\"some description\",display_order:1,id:1,label:\"some label\",name:\"some name\",system_name:\"some system name\",type_id:1}"
        val actualResultField = ResultField(
                configs = Array<Configuration>(1) { Configuration() },
                description = "some description",
                displayOrder = 1,
                id = 1,
                label = "some label",
                name = "some name",
                systemName = "some system name",
                typeId = 1
        )
        println(JSON.unquoted.stringify(actualResultField))
        Assertions.assertEquals(expectedResultField,JSON.unquoted.stringify(actualResultField))
    }

    @Test
    fun deserializeResultFieldTest()
    {
        val expectedResultField = ResultField(
                configs = Array<Configuration>(1) { Configuration() },
                description = "some description",
                displayOrder = 1,
                id = 1,
                label = "some label",
                name = "some name",
                systemName = "some system name",
                typeId = 1
        )
        Assertions.assertEquals(expectedResultField.toString(),JSON.unquoted.parse<ResultField>("{configs:[{group_id:null,id:null,name:null}],description:\"some description\",display_order:1,id:1,label:\"some label\",name:\"some name\",system_name:\"some system name\",type_id:1}").toString())
    }

    @Test
    fun getResultFieldsTest()
    {

    }
}