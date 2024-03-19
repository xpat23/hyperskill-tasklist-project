package tasklist

import tasklist.command.*
import tasklist.input.CommandInput
import tasklist.model.JsonTaskStorage
import tasklist.model.TaskRepository

fun main() {

    val taskStorage = JsonTaskStorage()
    val taskRepository = TaskRepository(taskStorage.load().toMutableList())

    val commands = mapOf(
        "add" to AddTaskCommand(taskRepository),
        "print" to PrintTaskCommand(taskRepository),
        "edit" to EditTaskCommand(taskRepository),
        "delete" to DeleteCommand(taskRepository),
        "end" to TaskListExitingCommand(taskStorage, taskRepository)
    )

    TaskListApplication(
        CommandInput(commands)
    ).run()
}




