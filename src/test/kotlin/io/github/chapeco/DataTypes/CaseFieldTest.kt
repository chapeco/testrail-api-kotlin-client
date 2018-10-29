package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Type
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CaseFieldTest
{
    @Test
    fun instantiateCaseFieldTest()
    {
        val expectedCaseField = CaseField(
                id = 1,
                systemName = "some system name",
                entityId = 1,
                typeId = 1,
                locationId = 1,
                displayOrder = 1,
                isMulti = true,
                isActive = true,
                statusId = 1,
                isSystem = true,
                type = Type.FOO,
                name = "some name",
                label = "some label",
                description = "some description",
                includeAll = true,
                templateIds = Array<Int>(1) {1},
                configs = Array<Configuration>(1) { Configuration() }
        )
        val actualCaseField = CaseField(
                id = 1,
                systemName = "some system name",
                entityId = 1,
                typeId = 1,
                locationId = 1,
                displayOrder = 1,
                isMulti = true,
                isActive = true,
                statusId = 1,
                isSystem = true,
                type = Type.FOO,
                name = "some name",
                label = "some label",
                description = "some description",
                includeAll = true,
                templateIds = Array<Int>(1) {1},
                configs = Array<Configuration>(1) {Configuration()}
        )
        assertEquals(expectedCaseField.toString(),actualCaseField.toString())
    }

    @Test
    fun serializeCaseFieldTest()
    {
        val expectedCaseField: String = "{id:1,system_name:\"some system name\",entity_id:1,type_id:1,location_id:1,display_order:1,is_multi:true,is_active:true,status_id:1,is_system:true,type:FOO,name:\"some name\",label:\"some label\",description:\"some description\",include_all:true,template_ids:[1],configs:[{group_id:null,id:null,name:null}]}"
        val actualCaseField = CaseField(
                id = 1,
                systemName = "some system name",
                entityId = 1,
                typeId = 1,
                locationId = 1,
                displayOrder = 1,
                isMulti = true,
                isActive = true,
                statusId = 1,
                isSystem = true,
                type = Type.FOO,
                name = "some name",
                label = "some label",
                description = "some description",
                includeAll = true,
                templateIds = Array<Int>(1) {1},
                configs = Array<Configuration>(1) {Configuration()}
        )
        println(JSON.unquoted.stringify(actualCaseField))
        Assertions.assertEquals(expectedCaseField, JSON.unquoted.stringify(actualCaseField))
    }

    @Test
    fun deserializeCaseFieldTest()
    {
        val expectedCaseField = CaseField(
                id = 1,
                systemName = "some system name",
                entityId = 1,
                typeId = 1,
                locationId = 1,
                displayOrder = 1,
                isMulti = true,
                isActive = true,
                statusId = 1,
                isSystem = true,
                type = Type.FOO,
                name = "some name",
                label = "some label",
                description = "some description",
                includeAll = true,
                templateIds = Array<Int>(1) {1},
                configs = Array<Configuration>(1) {Configuration()}
        )
        Assertions.assertEquals(expectedCaseField.toString(),JSON.unquoted.parse<CaseField>("{id:1,system_name:\"some system name\",entity_id:1,type_id:1,location_id:1,display_order:1,is_multi:true,is_active:true,status_id:1,is_system:true,type:FOO,name:\"some name\",label:\"some label\",description:\"some description\",include_all:true,template_ids:[1],configs:[{group_id:null,id:null,name:null}]}").toString())
    }

    @Test
    fun getCaseFieldsTest()
    {

    }

    @Test
    fun addCaseFieldTest()
    {

    }
}