package io.github.chapeco.Utilities

data class Timestamp
(
    var time: Long? = null
)
{
    override fun toString(): String {
        return time.toString()
    }
}