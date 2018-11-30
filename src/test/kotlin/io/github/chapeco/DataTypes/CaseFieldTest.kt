package io.github.chapeco.DataTypes

import io.github.chapeco.DataTypes.SubTypes.Config
import io.github.chapeco.DataTypes.SubTypes.Context
import io.github.chapeco.DataTypes.SubTypes.Options
import io.github.chapeco.Utilities.Type
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class CaseFieldTest
{
    val jsonPayload = "{id:1,system_name:\"some system name\",entity_id:1,type_id:1,location_id:1,display_order:1,is_multi:true,is_active:true,status_id:1,is_system:true,type:FOO,name:\"some name\",label:\"some label\",description:\"some description\",include_all:true,template_ids:[1],configs:[{group_id:null,id:null,name:null}]}"

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
                templateIds = List<Int>(1) {1},
                configs = List<Config>(1) { Config() }
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
                templateIds = List<Int>(1) {1},
                configs = List<Config>(1) { Config() }
        )
        assertEquals(expectedCaseField.toString(),actualCaseField.toString())
    }

    @Test
    fun serializeCaseFieldTest()
    {
        val expectedCaseField: String = jsonPayload
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
                templateIds = List<Int>(1) {1},
                configs = List<Config>(1) { Config() }
        )
        println(JSON.unquoted.stringify(actualCaseField))
        Assert.assertEquals(expectedCaseField, JSON.unquoted.stringify(actualCaseField))
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
                templateIds = List<Int>(1) {1},
                configs = List<Config>(1) { Config() }
        )
        Assert.assertEquals(expectedCaseField.toString(),JSON.unquoted.parse<CaseField>(jsonPayload).toString())
    }

    @Test
    fun getCaseFieldsTest()
    {
        val expectedCaseFieldsList = listOf(
                CaseField(
                        id = 1,
                        isActive = true,
                        typeId = 3,
                        name = "preconds",
                        systemName = "custom_preconds",
                        label = "Preconditions",
                        description = "The preconditions of this test case. Reference other test cases with [C#] (e.g. [C17]).",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                defaultValue = "",
                                                format = "markdown",
                                                rows = 7
                                        ),
                                        id = "4be1344d55d11"
                                )
                        ),
                        displayOrder = 1,
                        includeAll = false,
                        templateIds = listOf(1,2)
                ),
                CaseField(
                        id = 2,
                        isActive = true,
                        typeId = 3,
                        name = "steps",
                        systemName = "custom_steps",
                        label = "Steps",
                        description = "The required steps to execute the test case.",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                defaultValue = "",
                                                format = "markdown",
                                                rows = 7
                                        ),
                                        id = "4be97c65ea2fd"
                                )
                        ),
                        displayOrder = 2,
                        includeAll = false,
                        templateIds = listOf(1)
                ),
                CaseField(
                        id = 3,
                        isActive = true,
                        typeId = 3,
                        name = "expected",
                        systemName = "custom_expected",
                        label = "Expected Result",
                        description = "The expected result after executing the test case.",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                defaultValue = "",
                                                format = "markdown",
                                                rows = 7
                                        ),
                                        id = "4be1345cafd07"
                                )
                        ),
                        displayOrder = 3,
                        includeAll = false,
                        templateIds = listOf(1)
                ),
                CaseField(
                        id = 10,
                        isActive = true,
                        typeId = 10,
                        name = "steps_separated",
                        systemName = "custom_steps_separated",
                        label = "Steps",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                format = "markdown",
                                                hasExpected = true,
                                                rows = 5
                                        ),
                                        id = "4be97c65ea2fd"
                                )
                        ),
                        displayOrder = 4,
                        includeAll = false,
                        templateIds = listOf(2)
                ),
                CaseField(
                        id = 12,
                        isActive = true,
                        typeId = 3,
                        name = "mission",
                        systemName = "custom_mission",
                        label = "Mission",
                        description = "A high-level overview of what to test and which areas to cover, usually just 1-2 sentences.",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                defaultValue = "",
                                                format = "markdown",
                                                rows = 7
                                        ),
                                        id = "4be1345cafd07"
                                )
                        ),
                        displayOrder = 5,
                        includeAll = false,
                        templateIds = listOf(3)
                ),
                CaseField(
                        id = 13,
                        isActive = true,
                        typeId = 3,
                        name = "goals",
                        systemName = "custom_goals",
                        label = "Goals",
                        description = "A detailed list of goals to cover as part of the exploratory sessions.",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                defaultValue = "",
                                                format = "markdown",
                                                rows = 7
                                        ),
                                        id = "4be1345cafd07"
                                )
                        ),
                        displayOrder = 6,
                        includeAll = false,
                        templateIds = listOf(
                                3
                        )
                ),
                CaseField(
                        id = 14,
                        isActive = true,
                        typeId = 6,
                        name = "automation_type",
                        systemName = "custom_automation_type",
                        label = "Automation Type",
                        configs = listOf(
                                Config(
                                        context = Context(
                                                isGlobal = true,
                                                projectIds = listOf<Int>()
                                        ),
                                        options = Options(
                                                isRequired = false,
                                                defaultValue = "0",
                                                items = "0, None\n1, Ranorex"
                                        ),
                                        id = "7a34a519-f458-40bb-af43-ed63baf874ee"
                                )
                        ),
                        displayOrder = 5,
                        includeAll = true,
                        templateIds = listOf<Int>()
                )
        )
        val actualCaseFieldsList = CaseField().getCaseFields()
        println(JSON.unquoted.stringify(CaseField.serializer().list,actualCaseFieldsList))
        Assert.assertEquals(expectedCaseFieldsList,actualCaseFieldsList)
    }

    @Test
    fun addCaseFieldTest()
    {

    }
}