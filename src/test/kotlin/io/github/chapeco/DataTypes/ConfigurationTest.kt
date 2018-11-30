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

    }

    @Test
    fun addConfigTest()
    {

    }

    @Test
    fun updateConfigGroupTest()
    {

    }

    @Test
    fun updateConfigTest()
    {

    }

    @Test
    fun deleteConfigGroupTest()
    {

    }

    @Test
    fun deleteConfigTest()
    {

    }
}