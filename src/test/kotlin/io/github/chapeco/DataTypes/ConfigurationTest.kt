package io.github.chapeco.DataTypes

import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        Assertions.assertEquals(expectedConfiguration,actualConfiguration)
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
        Assertions.assertEquals(expectedConfiguration,JSON.unquoted.stringify(actualConfiguration))
    }

    @Test
    fun deserializeConfigurationTest()
    {
        val expectedConfiguration = Configuration(
                id = 1,
                name = "some name"
        )
        Assertions.assertEquals(expectedConfiguration, JSON.unquoted.parse<Configuration>("{group_id:null,id:1,name:\"some name\"}"))
    }

    @Test
    fun getConfigsTest()
    {

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