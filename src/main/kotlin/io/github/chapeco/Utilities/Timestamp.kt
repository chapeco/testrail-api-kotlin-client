package io.github.chapeco.Utilities

import kotlinx.serialization.Serializable

@Serializable
data class Timestamp
(
    var time: Long? = null
)
{
    override fun toString(): String {
        return time.toString()
    }
}