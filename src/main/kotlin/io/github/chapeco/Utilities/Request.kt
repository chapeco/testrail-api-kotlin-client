package io.github.chapeco.Utilities

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.serialization.json.JSON

class Request()
{
    fun Get(endpoint: String): JSON?
    {
        var returnValue: JSON? = null
        Fuel.get(endpoint)
        return returnValue
    }

    fun Post(endpoint: String, jsonPayload: String): Request
    {
        return endpoint.httpPost().body(jsonPayload, Charsets.UTF_8).header("Content-Type" to "application/json").response { request, response, result ->
            when(result){
                is Result.Failure -> {
                    val ex = result.getException()
                }
                is Result.Success -> {
                    val data = result.get()
                }
            }
        }
    }

}