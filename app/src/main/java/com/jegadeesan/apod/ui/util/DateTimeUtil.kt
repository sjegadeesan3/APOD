package com.jegadeesan.apod.ui.util

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtil {

    private const val DATE_FORMAT = "yyyy-MM-dd"

    fun getCurrentDate(): String {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(Date())
    }

    fun getDateBefore(noOfDaysBefore: Int): String {
        val cal: Calendar = GregorianCalendar()
        cal.time = Date()
        cal.add(Calendar.DAY_OF_MONTH, -noOfDaysBefore)
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(cal.time)
    }
}