package tasklist.input

import kotlinx.datetime.LocalDate

class DateInput {
    fun read(): LocalDate {
        println("Input the date (yyyy-mm-dd):")
        val str = readln()


        try {
            val date = str.split("-").map { it.toInt() }
            return LocalDate(
                date[0],
                date[1],
                date[2]
            )
        } catch (e: Throwable) {
            println("The input date is invalid")
            return read()
        }
    }
}
