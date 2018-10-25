package io.github.chapeco

import io.github.chapeco.Utilities.Request
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet

data class TestRail
(
    val endpoint: String,
    val username: String,
    val password: String
)
{
    private val indexBase = "index.php?/api/v2/"
    init {
        FuelManager.instance.basePath = endpoint
        "/get".httpGet().responseString { request, response, result ->  
            val (data, error) = result
            if (error == null) {

            } else {

            }
        }
    }

    fun foo()
    {
        Request().Get("/get")
    }
}