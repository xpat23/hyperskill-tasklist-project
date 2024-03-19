package tasklist.command

import tasklist.model.TaskRepository
import tasklist.output.TaskListPrinter

class PrintTaskCommand(private val taskRepository: TaskRepository) : TaskListCommand {
    override fun execute(): Boolean {
        val tasks = taskRepository.findAll()
        if (tasks.isEmpty()) {
            println("No tasks have been input")
            return true
        }

        TaskListPrinter(tasks).print()
        return true
    }
}
