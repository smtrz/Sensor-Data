package com.tahir.pessl_instruments.Helpers


import com.tahir.pessl_instruments.Configurations.App
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

class DateHelper {

    val ONE_SECOND: Long = 1000
    val SECONDS: Long = 60

    val ONE_MINUTE = ONE_SECOND * 60
    val MINUTES: Long = 60

    val ONE_HOUR = ONE_MINUTE * 60
    val HOURS: Long = 24

    val ONE_DAY = ONE_HOUR * 24
    @Inject
    lateinit var now: Date
    //@Inject @Named("current_time")
    @Inject @field:Named("current_time")

    lateinit var dateFormat_current_time: SimpleDateFormat
  //  @Inject @Named("device_time")
    @Inject @field:Named("device_time")

    lateinit var dateFormat_device_Time: SimpleDateFormat

    init {
        App.app.appLevelComponent.inject(this@DateHelper)
    }

    /**
     * Calculate Date Difference
     *
     * This method is used to calculate hour differnce .
     *
     * @param String Date .
     * @return long  time difference
     *
     *
     */
    fun calculateDateDifference(newsDate: String): Long {


        var difference: Long = 0
        try {
            val newsdate = dateFormat_device_Time!!.parse(newsDate)
            val current_date = dateFormat_current_time!!.parse(now.toString())


            difference = TimeUnit.MILLISECONDS.toHours(current_date!!.time - newsdate.time)

        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return difference
    }

    /**
     * converts time (in milliseconds) to human-readable format
     * "<w> days, <x> hours, <y> minutes and (z) seconds"
    </y></x></w> */
    fun millisToLongDHMS(duration: Long): String? {
        var duration = duration
        val res = StringBuffer()
        var temp: Long = 0
        return if (duration >= ONE_SECOND) {
            temp = duration / ONE_DAY
            if (temp > 0) {
                duration -= temp * ONE_DAY
                res.append(temp).append(" day").append(if (temp > 1) "s" else "")
                    .append(if (duration >= ONE_MINUTE) ", " else "")
            }
            temp = duration / ONE_HOUR
            if (temp > 0) {
                duration -= temp * ONE_HOUR
                res.append(temp).append(" hour").append(if (temp > 1) "s" else "")
                    .append(if (duration >= ONE_MINUTE) ", " else "")
            }
            temp = duration / ONE_MINUTE
            if (temp > 0) {
                duration -= temp * ONE_MINUTE
                res.append(temp).append(" minute").append(if (temp > 1) "s" else "")
            }
            if (res.toString() != "" && duration >= ONE_SECOND) {
                res.append(" and ")
            }
            temp = duration / ONE_SECOND
            if (temp > 0) {
                res.append(temp).append(" second").append(if (temp > 1) "s" else "")
            }
            res.toString()
        } else {
            "0 second"
        }
    }


    fun Get_Duration(
        get_24hr_converted_vehicletime: String?,
        get_Current_date: String?
    ): String? {
        val msg = ""
        val sdf =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        // Date DateStart =
        var DateStart: Date? = null
        var DateEnd: Date? = null
        try {
            DateEnd = sdf.parse(get_Current_date)
            println(DateStart)
            DateStart = sdf.parse(get_24hr_converted_vehicletime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return printDifference(DateStart, DateEnd)
    }

    fun printDifference(
        startDate: Date?,
        endDate: Date?
    ): String? { //milliseconds
        var different = endDate!!.time - startDate!!.time
        println("startDate : $startDate")
        println("endDate : $endDate")
        println("different : $different")
        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different = different % daysInMilli
        val elapsedHours = different / hoursInMilli
        different = different % hoursInMilli
        val elapsedMinutes = different / minutesInMilli
        different = different % minutesInMilli
        val elapsedSeconds = different / secondsInMilli
        System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n",
            elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds
        )
        var duration = ""
        var Isinitial = false
        var count = 0
        if (elapsedDays >= 1) {
            duration = "$duration$elapsedDays days"
            Isinitial = true
            count++
          //  duration = "$duration ago"
          //  return duration
        }
        if (elapsedHours >= 1) {
            if (Isinitial == true) {
                duration = "$duration, "
            }
            duration = "$duration$elapsedHours hours"
            Isinitial = true
            count++
        }
        if (elapsedMinutes >= 1) {
            if (count < 2) {
                if (Isinitial == true) {
                    duration = "$duration, "
                }
                duration = "$duration$elapsedMinutes minutes"
                Isinitial = true
                count++
            }
        }
        if (elapsedSeconds >= 1) {
            if (count < 2) {
                if (Isinitial == true) {
                    duration = "$duration, "
                }
                duration = "$duration$elapsedSeconds seconds"
                Isinitial = true
                count++
            }
        }
        if (elapsedSeconds < 1) {
            if (count < 2) {
                if (Isinitial == false) {
                    duration = duration + "less than a second"
                    //duration=duration+", "
                }
            }
        }
        duration = "$duration ago"
        return duration
    }
    fun get_current_datetime_24hr(): String? {

        return dateFormat_current_time.format(Date())
    }
    //}
}