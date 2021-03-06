package com.jegadeesan.apod.data.util

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

    fun convertStringToDate(dateInString: String?): Date? {
        dateInString?.let {
            return SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH).parse(dateInString)
        } ?:run {
            return null
        }
    }

    fun convertDateToString(date: Date?, format: String = DATE_FORMAT): String {
        date?.let {
            return SimpleDateFormat(format, Locale.ENGLISH).format(it)
        } ?:run {
            return ""
        }
    }
}