package io.github.chapeco.Utilities

data class Timespan
(
    var days: Int = 0,
    var hours: Int = 0,
    var minutes: Int = 0,
    var seconds: Int = 0
)
{

    private val daysString: String = "d"
    private val hoursString: String = "h"
    private val minutesString: String = "m"
    private val secondsString: String = "s"

    fun getTimespan(): String{
        var timespanString: String = ""
        if (days > 0) timespanString = timespanString + days + daysString
        if (hours > 0) timespanString = timespanString + hours + hoursString
        if (minutes > 0) timespanString = timespanString + minutes + minutesString
        if (seconds > 0) timespanString = timespanString + seconds + secondsString
        return timespanString
    }

    override fun toString(): String {
        return getTimespan()
    }
}