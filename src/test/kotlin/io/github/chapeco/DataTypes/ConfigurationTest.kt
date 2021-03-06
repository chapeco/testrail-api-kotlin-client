package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import org.junit.Assert
import org.junit.Test

class ConfigurationTest
{
    @Test
    fun instantiateConfigurationTest()
    {
        val expectedConfiguration = Configuration(
                id = 1,
                name = "some name"
        )
        val actualConfiguration = Configuration(
                id = 1,
                name = "some name"
        )
        Assert.assertEquals(expectedConfiguration,actualConfiguration)
    }

    @Test
    fun serializeConfigurationTest()
    {
        val expectedConfiguration: String = "{group_id:null,id:1,name:\"some name\"}"
        val actualConfiguration = Configuration(
                id = 1,
                name = "some name"
        )
        println(JSON.unquoted.stringify(actualConfiguration))
        Assert.assertEquals(expectedConfiguration,JSON.unquoted.stringify(actualConfiguration))
    }

    @Test
    fun deserializeConfigurationTest()
    {
        val expectedConfiguration = Configuration(
                id = 1,
                name = "some name"
        )
        Assert.assertEquals(expectedConfiguration, JSON.unquoted.parse<Configuration>("{group_id:null,id:1,name:\"some name\"}"))
    }

    @Test
    fun getConfigsTest()
    {
        val expectedConfigurationsList = listOf<Configuration>()
        val actualConfigurationsList = Configuration().getConfigs(1)
        println(JSON.unquoted.stringify(Configuration.serializer().list,actualConfigurationsList))
        Assert.assertEquals(expectedConfigurationsList,actualConfigurationsList)
    }

    @Test
    fun addConfigGroupTest()
    {
        val expectedConfigurationGroup = Configuration(name = "API TEST Configuration Group", projectId = 1)
        val actualConfigurationGroup = expectedConfigurationGroup.addConfigGroup()
        System.setProperty("configurationGroupId",actualConfigurationGroup.id.toString())
        println(JSON.unquoted.stringify(actualConfigurationGroup))
        Assert.assertEquals(expectedConfigurationGroup.name,actualConfigurationGroup.name)
    }

    @Test
    fun addConfigTest()
    {
        val expectedConfiguration = Configuration(name = "API TEST Configuration", groupId = System.getProperty("configurationGroupId").toInt())
        val actualConfiguration = expectedConfiguration.addConfig()
        System.setProperty("configurationId",actualConfiguration.id.toString())
        println(JSON.unquoted.stringify(actualConfiguration))
        Assert.assertEquals(expectedConfiguration.name,actualConfiguration.name)
    }

    @Test
    fun updateConfigGroupTest()
    {
        val expectedUpdatedConfigurationGroup = Configuration(name = "API TEST Updated Configuration Group", id = System.getProperty("configurationGroupId").toInt())
        val actualUpdatedConfigurationGroup = expectedUpdatedConfigurationGroup.updateConfigGroup()
        println(JSON.unquoted.stringify(actualUpdatedConfigurationGroup))
        Assert.assertEquals(expectedUpdatedConfigurationGroup.name,actualUpdatedConfigurationGroup.name)
    }

    @Test
    fun updateConfigTest()
    {
        val expectedUpdatedConfiguration = Configuration(name = "API TEST Updated Configuration", id = System.getProperty("configurationId").toInt())
        val actualUpdatedConfiguration = expectedUpdatedConfiguration.updateConfig()
        println(JSON.unquoted.stringify(actualUpdatedConfiguration))
        Assert.assertEquals(expectedUpdatedConfiguration.name,actualUpdatedConfiguration.name)
    }

    @Test
    fun deleteConfigGroupTest()
    {
        val expectedConfigurationGroup = Configuration(id = System.getProperty("configurationGroupId").toInt())
        expectedConfigurationGroup.deleteConfigGroup()
    }

    @Test
    fun deleteConfigTest()
    {
        val expectedConfiguration = Configuration(id = System.getProperty("configurationId").toInt())
        expectedConfiguration.deleteConfig()
    }
}