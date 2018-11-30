package io.github.chapeco.Utilities

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.serialization.json.JSON

class Request
{
    private val endpoint = System.getProperty("testrailEndpoint")
    private val indexBase = "index.php?/api/v2/"
    private val username = System.getProperty("testrailUsername")
    val password = System.getProperty("testrailPassword")

    init {
        FuelManager.instance.basePath = endpoint + indexBase
        FuelManager.instance.baseHeaders = hashMapOf(
                "Content-Type" to "application/json"
        )
        println(FuelManager.instance.basePath)
    }

    fun Get(endpoint: String): String?
    {
        val (request, response, result) = endpoint.httpGet()
                .authenticate(username,password)
                .responseString()
        val (data, error) = result
        if(error == null)
        {
            return data
        }
        else
        {
            throw error
        }
    }

    fun Post(endpoint: String, jsonPayload: String): String?
    {
        println(jsonPayload.replace(":\"null\"",":null"))
        val (request, response, result) = endpoint.httpPost()
                .authenticate(username,password)
                .body(jsonPayload.replace(":\"null\"",":null"))
                .also { println(it) }
                .responseString()
        val (data, error) = result
        if(error == null)
        {
            println(data)
            return data
        }
        else
        {
            throw error
        }
    }

}