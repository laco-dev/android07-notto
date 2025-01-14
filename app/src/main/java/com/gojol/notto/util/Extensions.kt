package com.gojol.notto.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun Calendar.toYearMonth(): String {
    return "${this.get(Calendar.YEAR)}년 ${this.get(Calendar.MONTH) + 1}월"
}

fun Calendar.toYearMonthDate(): String {
    return "${this.get(Calendar.YEAR)}${this.get(Calendar.MONTH) + 1}${this.get(Calendar.DATE)}"
}

fun Calendar.getYear(): Int {
    return this.get(Calendar.YEAR)
}

fun Calendar.getMonth(): Int {
    return this.get(Calendar.MONTH)
}

fun Calendar.getDate(): Int {
    return this.get(Calendar.DATE)
}

fun Calendar.getDayOfWeek(): Int {
    return this.get(Calendar.DAY_OF_WEEK)
}

fun Calendar.getFirstDayOfMonth(): Int {
    return this.get(Calendar.DAY_OF_MONTH)
}

fun Calendar.getLastDayOfMonth(): Int {
    return this.getActualMaximum(Calendar.DATE)
}

fun Date.getDateString(): String {
    val simpleDateFormatDate = SimpleDateFormat("yyyyMMdd", Locale.KOREA)
    return simpleDateFormatDate.format(this)
}

fun Date.getTimeString(): String {
    val simpleDateFormatTime = SimpleDateFormat("a hh:mm", Locale.KOREA)
    return simpleDateFormatTime.format(this)
}

fun Long.getTimeString(): String {
    val simpleDateFormatTime = SimpleDateFormat("hh:mm", Locale.KOREA)
    return simpleDateFormatTime.format(this)
}

fun String.getDate(): Date? {
    val simpleDateFormatDate = SimpleDateFormat("yyyyMMdd", Locale.KOREA)
    return simpleDateFormatDate.parse(this)
}

fun String.getTime(): Date? {
    val simpleDateFormatTime = SimpleDateFormat("a hh:mm", Locale.KOREA)
    return simpleDateFormatTime.parse(this)
}

fun String.get12Hour(): String {
    val simpleDateFormatTime = SimpleDateFormat("kk:mm", Locale.KOREA)
    simpleDateFormatTime.parse(this)?.let {
        return SimpleDateFormat("a hh:mm", Locale.KOREA).format(it)
    } ?: run {
        return SimpleDateFormat("a hh:mm", Locale.KOREA).format(System.currentTimeMillis())
    }
}

fun String.get24Hour(): String {
    val simpleDateFormatTime = SimpleDateFormat("a hh:mm", Locale.KOREA)
    simpleDateFormatTime.parse(this)?.let {
        return SimpleDateFormat("kk:mm", Locale.KOREA).format(it)
    } ?: run {
        return SimpleDateFormat("kk:mm", Locale.KOREA).format(System.currentTimeMillis())
    }
}

fun String.timeSplitFormatter(): List<String> {
    return this.split(":")
}
