package tasklist.input

import kotlinx.datetime.LocalDateTime
import tasklist.model.TaskDeadline

class TaskDeadlineInput(
    private val dateInput: DateInput,
    private val timeInput: TimeInput
) {


    fun read(): TaskDeadline {

        val date = dateInput.read()
        val time = timeInput.read()

        return TaskDeadline(
            LocalDateTime(
                date.year,
                date.monthNumber,
                date.dayOfMonth,
                time.hour,
                time.minute
            )
        )
    }
}
