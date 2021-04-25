package com.jegadeesan.apod.data.util

import com.jegadeesan.apod.data.util.DateTimeUtil.convertStringToDate
import junit.framework.TestCase
import org.junit.Test

class DateTimeUtilTest : TestCase() {

    @Test
    fun testGetDateFromString() {
        val date = convertStringToDate("2021-02-01")
        println(date)
    }
}