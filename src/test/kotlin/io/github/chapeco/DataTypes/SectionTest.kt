package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SectionTest
{
    @Test
    fun instantiateSectionTest()
    {
        val expectedSection = Section(
                depth = 1,
                displayOrder = 1,
                id = 1,
                description = "some description",
                suiteId = 1,
                parentId = 1,
                name = "some name"
        )
        val actualSection = Section(
                depth = 1,
                displayOrder = 1,
                id = 1,
                description = "some description",
                suiteId = 1,
                parentId = 1,
                name = "some name"
        )
        Assertions.assertEquals(expectedSection,actualSection)
    }

    @Test
    fun serializeSectionTest()
    {
        val expectedSection: String = "{depth:1,display_order:1,id:1,description:\"some description\",suite_id:1,parent_id:1,name:\"some name\"}"
        val actualSection = Section(
                depth = 1,
                displayOrder = 1,
                id = 1,
                description = "some description",
                suiteId = 1,
                parentId = 1,
                name = "some name"
        )
        println(JSON.unquoted.stringify(actualSection))
        Assertions.assertEquals(expectedSection,JSON.unquoted.stringify(actualSection))
    }

    @Test
    fun deserializeSectionTest()
    {
        val expectedSection = Section(
                depth = 1,
                displayOrder = 1,
                id = 1,
                description = "some description",
                suiteId = 1,
                parentId = 1,
                name = "some name"
        )
        Assertions.assertEquals(expectedSection,JSON.unquoted.parse<Section>("{depth:1,display_order:1,id:1,description:\"some description\",suite_id:1,parent_id:1,name:\"some name\"}"))
    }

    @Test
    fun getSectionTest()
    {

    }

    @Test
    fun getSectionsTest()
    {

    }

    @Test
    fun addSectionTest()
    {

    }

    @Test
    fun updateSectionTest()
    {

    }

    @Test
    fun deleteSectionTest()
    {

    }
}