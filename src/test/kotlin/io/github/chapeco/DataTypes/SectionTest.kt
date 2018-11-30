package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

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
        Assert.assertEquals(expectedSection,actualSection)
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
        Assert.assertEquals(expectedSection,JSON.unquoted.stringify(actualSection))
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
        Assert.assertEquals(expectedSection,JSON.unquoted.parse<Section>("{depth:1,display_order:1,id:1,description:\"some description\",suite_id:1,parent_id:1,name:\"some name\"}"))
    }

    @Test
    fun getSectionTest()
    {
        val expectedSection = JSON.unquoted.parse<Section>("{depth:0,display_order:1,id:1,description:null,suite_id:1,parent_id:null,name:API_Test_Section}")
        val actualSection = Section().getSection(1)
        println(JSON.unquoted.stringify(actualSection))
        Assert.assertEquals(expectedSection,actualSection)
    }

    @Test
    fun getSectionsTest()
    {
        val expectedSectionsList = listOf(
                JSON.unquoted.parse<Section>("{depth:0,display_order:1,id:1,description:null,suite_id:1,parent_id:null,name:API_Test_Section}")
        )
        val actualSectionsList = Section().getSections(1,1)
        println(JSON.unquoted.stringify(Section.serializer().list,actualSectionsList))
        Assert.assertEquals(expectedSectionsList,actualSectionsList)
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