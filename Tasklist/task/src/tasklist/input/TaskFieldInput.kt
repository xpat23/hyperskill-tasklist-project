package tasklist.input

import tasklist.model.TaskField

class TaskFieldInput {

    fun read(): TaskField {
        println("Input a field to edit (priority, date, time, task):")
        val field = readln().lowercase()
        return try {
            TaskField.fromValue(field)
        } catch (e: IllegalArgumentException) {
            println("Invalid field")
            read()
        }
    }
}
