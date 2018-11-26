package io.github.chapeco.Utilities

import kotlinx.serialization.Serializable

@Serializable
data class Timestamp
(
    var time: Long? = -1
)
{
    override fun toString(): String {
        return time.toString()
    }
}