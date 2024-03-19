package tasklist.model

import kotlinx.datetime.*

data class TaskDeadline(
    val dateTime: LocalDateTime,
) {
    constructor(dateTime: String) : this(LocalDateTime.parse(dateTime.replaceFirst(' ', 'T') + ":00"))

    private fun overdueStatus(): String {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date
        val numberOfDays = currentDate.daysUntil(dateTime.date)
        return when {
            numberOfDays == 0 -> "T"
            numberOfDays > 0 -> "I"
            else -> "O"
        }
    }

    fun dueTagColor(): String {
        return when (overdueStatus()) {
            "T" -> "\u001B[103m \u001B[0m"
            "I" -> "\u001B[102m \u001B[0m"
            "O" -> "\u001B[101m \u001B[0m"
            else -> throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        val month = dateTime.monthNumber.toString().padStart(2, '0')
        val day = dateTime.dayOfMonth.toString().padStart(2, '0')
        val hour = dateTime.hour.toString().padStart(2, '0')
        val minute = dateTime.minute.toString().padStart(2, '0')

        return "${dateTime.year}-$month-$day $hour:$minute"
    }

    fun dateString(): String {
        val month = dateTime.monthNumber.toString().padStart(2, '0')
        val day = dateTime.dayOfMonth.toString().padStart(2, '0')
        return "${dateTime.year}-$month-$day"
    }

    fun timeString(): String {
        val hour = dateTime.hour.toString().padStart(2, '0')
        val minute = dateTime.minute.toString().padStart(2, '0')
        return "$hour:$minute"
    }

    fun withDate(date: LocalDate): TaskDeadline {
        return TaskDeadline(
            LocalDateTime(
                date.year,
                date.monthNumber,
                date.dayOfMonth,
                dateTime.hour,
                dateTime.minute
            )
        )
    }

    fun withTime(time: LocalDateTime): TaskDeadline {
        return TaskDeadline(
            LocalDateTime(
                dateTime.year,
                dateTime.monthNumber,
                dateTime.dayOfMonth,
                time.hour,
                time.minute
            )
        )
    }
}
