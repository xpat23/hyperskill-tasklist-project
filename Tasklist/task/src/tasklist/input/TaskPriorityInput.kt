package tasklist.input

import tasklist.model.TaskPriority

class TaskPriorityInput {
    fun read(): TaskPriority {
        println("Input the task priority (C, H, N, L):")
        val priority = readln().uppercase()
        return try {
            TaskPriority.fromValue(priority)
        } catch (e: IllegalArgumentException) {
            read()
        }
    }
}
