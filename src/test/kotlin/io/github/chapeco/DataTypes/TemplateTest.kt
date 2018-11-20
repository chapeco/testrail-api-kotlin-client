package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
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
        val expectedTemplatesList = listOf(
                Template(
                        id = 1,
                        isDefault = true,
                        name = "Test Case (Text)"
                ),
                Template(
                        id = 2,
                        isDefault = false,
                        name = "Test Case (Steps)"
                ),
                Template(
                        id = 3,
                        isDefault = false,
                        name = "Exploratory Session"
                )
        )
        val actualTemplatesList = Template().getTemplates(1)
        println(JSON.stringify(Template.serializer().list,actualTemplatesList))
        Assertions.assertEquals(expectedTemplatesList,actualTemplatesList)
    }
}