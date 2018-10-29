package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TemplateTest
{
    @Test
    fun instantiateTemplateTest()
    {
        val expectedTemplate = Template(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        val actualTemplate = Template(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        Assertions.assertEquals(expectedTemplate,actualTemplate)
    }

    @Test
    fun serializeTemplateTest()
    {
        val expectedTemplate: String = "{id:1,is_default:true,name:\"some name\"}"
        val actualTemplate = Template(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        println(JSON.unquoted.stringify(actualTemplate))
        Assertions.assertEquals(expectedTemplate,JSON.unquoted.stringify(actualTemplate))
    }

    @Test
    fun deserializeTemplateTest()
    {
        val expectedTemplate = Template(
                id = 1,
                isDefault = true,
                name = "some name"
        )
        Assertions.assertEquals(expectedTemplate,JSON.unquoted.parse<Template>("{id:1,is_default:true,name:\"some name\"}"))
    }

    @Test
    fun getTemplatesTest()
    {

    }
}