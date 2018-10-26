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

    private fun getTimespan(): String{
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

    fun parseTimespan(timespanString: String?): Timespan{
        var currentString = timespanString!!.replace(" ","")
        var days: Int = 0
        var hours: Int = 0
        var minutes: Int = 0
        var seconds: Int = 0
        if(currentString.split("d").size > 1)
        {
            var splitString = currentString.split("d")
            days = splitString[0].toInt()
            currentString = splitString[1]
        }
        if(currentString.split("h").size > 1)
        {
            var splitString = currentString.split("h")
            hours = splitString[0].toInt()
            currentString = splitString[1]
        }
        if(currentString.split("m").size > 1)
        {
            var splitString = currentString.split("m")
            minutes = splitString[0].toInt()
            currentString = splitString[1]
        }
        if(currentString.split("s").isNotEmpty())
        {
            var splitString = currentString.split("s")
            seconds = splitString[0].toInt()
        }
        return Timespan(days, hours, minutes, seconds)
    }
}