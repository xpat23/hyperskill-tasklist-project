package tasklist.command

import tasklist.input.TaskNumberInput
import tasklist.model.TaskRepository
import tasklist.output.TaskListPrinter

class DeleteCommand(private val taskRepository: TaskRepository) : TaskListCommand {
    override fun execute(): Boolean {
        val tasks = taskRepository.findAll()

        if (tasks.isEmpty()) {
            println("No tasks have been input")
            return true
        }

        TaskListPrinter(tasks).print()

        val id = TaskNumberInput(1, tasks.size).read()

        taskRepository.delete(taskRepository.getById(id))

        println("The task is deleted")

        return true
    }
}
