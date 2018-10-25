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
        if (days > 0) timespanString = timespanString + daysString + days
        if (hours > 0) timespanString = timespanString + hoursString + hours
        if (minutes > 0) timespanString = timespanString + minutesString + minutes
        if (seconds > 0) timespanString = timespanString + secondsString + seconds
        return timespanString
    }
}