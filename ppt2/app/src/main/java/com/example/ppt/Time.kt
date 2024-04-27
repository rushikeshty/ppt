package com.example.ppt

import java.util.Calendar

internal fun getMinDelayTime(minDelay: Int): Calendar {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.SECOND, minDelay)

    if (calendar.get(Calendar.MINUTE) > 55) {
        calendar.add(Calendar.MINUTE, 60 - calendar.get(Calendar.MINUTE))
    }

    return calendar
}


internal fun getSelectedDelayTime(selectedDelayTime: Int): Calendar{
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.SECOND, selectedDelayTime)

    return calendar
}

internal fun getMaxDelayTime(maxDelay: Int): Calendar {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.SECOND, maxDelay)

    return calendar
}

internal fun getMinutes(selectedHour: Int, minDelay: Int, maxDelay: Int, increment: Int): List<String> {

    val minDelayTime = getMinDelayTime(minDelay)
    val maxDelayTime = getMaxDelayTime(maxDelay)

    val currentTimeMinute = minDelayTime.get(Calendar.MINUTE)
    val maxTimeMinute = maxDelayTime.get(Calendar.MINUTE)

    val currentTimeHourOfDay = minDelayTime.get(Calendar.HOUR_OF_DAY)
    val maxTimeHourOfDay = maxDelayTime.get(Calendar.HOUR_OF_DAY)

    /**
     * if selected_hour != (current_hour || max_hour) return 0..59
     * if selected_hour == current_hour return round(current_minute)..59
     * if selected_hour == max_hour return 0..max_minute
     * special case when maxDelay == 24 hour -> return 0..max_minute + round(current_minute)..59
     *
     * when increment is 1 hour show the current minute as the only available for each selected hour,
     * except for the maxHour where we check between current minute and maximum available minute (based on max delay)
     */
    return if ((selectedHour == currentTimeHourOfDay) && (selectedHour == maxTimeHourOfDay)) {
        if (maxDelay < 3600) {
            //same day, same hour
            //if max delay < 5 min return just current minute as available to select
            if (maxDelay < 300) listOf(minDelayTime).map { String.format("%02d", it) }
            else (currentTimeMinute..maxTimeMinute step increment).map { String.format("%02d", it) }.toList()
        } else {
            //different day, same hour
            ((0..maxTimeMinute step increment).map { String.format("%02d", it) }.toList()).plus(
                (currentTimeMinute..59 step increment).map { String.format("%02d", it) }.toList()
            ).distinct()
        }
    } else if (selectedHour == currentTimeHourOfDay) {
        //first available hour is selected
        (currentTimeMinute..59 step increment).map { String.format("%02d", it) }.toList()
    } else if (selectedHour == maxTimeHourOfDay) {
        //last available hour is selected
        if (increment == 3600) {
            if (currentTimeMinute > maxTimeMinute) {
                listOf(String.format("%02d", maxTimeMinute))
            } else {
                listOf(String.format("%02d", currentTimeMinute))
            }
        } else {
            (0..maxTimeMinute step increment).map { String.format("%02d", it) }.toList()
        }
    } else {
        if (increment == 3600) {
            listOf(String.format("%02d", currentTimeMinute))
        } else {
            (0..59 step increment).map { String.format("%02d", it) }.toList()
        }
    }
}

internal fun getSelectedDelayHourMinutePair(selectedDelayTime: Int): Pair<String, String> {
    val currentDelayTimeInSec = getSelectedDelayTime(selectedDelayTime)
    val hour = currentDelayTimeInSec.get(Calendar.HOUR_OF_DAY)
    val doubleZero = "00"

    val delayHourToPass = if (hour == 0) {
        doubleZero
    } else {
        currentDelayTimeInSec.get(Calendar.HOUR_OF_DAY).toString()
    }

    val delayMinute = if (currentDelayTimeInSec.get(Calendar.MINUTE) < 10) {
        "0${currentDelayTimeInSec.get(Calendar.MINUTE)}"
    } else {
        currentDelayTimeInSec.get(Calendar.MINUTE).toString()
    }

    return Pair(delayHourToPass, delayMinute)
}

internal fun getHourMinutePair(
    minDelay: Int,
    maxDelay: Int,
    increment: Int,
    selectedHour: Int
): Pair<List<String>, List<String>> {

    val minDelayTime = getMinDelayTime(minDelay)
    val maxDelayTime = getMaxDelayTime(maxDelay)

    val roundedMinutes = getMinutes(selectedHour, minDelay, maxDelay, increment)


    //startHour is currentHour OR firstHour from next meridian
    val startingHour = minDelayTime.get(Calendar.HOUR_OF_DAY)

    //endHour is currentHour OR lastHour from current meridian
    var endingHour = maxDelayTime.get(Calendar.HOUR_OF_DAY)

    // Meaning it's midnight
    if (endingHour == 0) {
        endingHour = 24
    }

    return Pair(getHoursList(startingHour, endingHour, maxDelay), roundedMinutes)
}

/**
 * return list of selectable hours
 * e.g: start 5 (17:00) end 2 (14:00) -> {5,6,7,8,9,10,11,12,1,2}
 */
private fun getHoursList(start: Int, end: Int, maxDelay: Int): List<String> {
    // special case when maxDelay <1 , =12 , =24
    if (start == end && maxDelay < 46800) {
        return listOf("$start")
    } else if (start == end) {
        val list = ArrayList<String>()
        var initValue = start
        list.add("$initValue")
        while (list.size < 24) {
            initValue += 1
            if (initValue > 24) {
                initValue -= 24
            }
            list.add("$initValue")
        }
        return list.toList()
    }

    val list = ArrayList<String>()
    var current = start
    list.add("$current")
    while (current != end) {
        current += 1
        if (current > 24) {
            current -= 24
        }
        if (current == 24)
            list.add("00")
        else
            list.add("$current")
    }
    return list.toList()
}

