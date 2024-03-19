package tasklist.input

import kotlinx.datetime.LocalDateTime

class TimeInput {
    fun read(): LocalDateTime {
        println("Input the time (hh:mm):")
        val str = readln()

        try {
            val time = str.split(":").map { it.toInt() }
            return LocalDateTime(
                2022,
                1,
                1,
                time[0],
                time[1]
            )
        } catch (e: Throwable) {
            println("The input time is invalid")
            return read()
        }
    }
}
