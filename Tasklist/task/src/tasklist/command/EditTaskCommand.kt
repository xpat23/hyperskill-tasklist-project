package tasklist.command

import tasklist.input.*
import tasklist.model.TaskField
import tasklist.model.TaskRepository
import tasklist.output.TaskListPrinter

class EditTaskCommand(private val taskRepository: TaskRepository) : TaskListCommand {
    override fun execute(): Boolean {
        val tasks = taskRepository.findAll()
        if (tasks.isEmpty()) {
            println("No tasks have been input")
            return true
        }

        TaskListPrinter(tasks).print()

        val id = TaskNumberInput(1, tasks.size).read()
        val field = TaskFieldInput().read()

        val task = taskRepository.getById(id)

        when (field) {
            TaskField.PRIORITY -> {
                val priority = TaskPriorityInput().read()
                taskRepository.update(task.withPriority(priority))
            }

            TaskField.DATE -> {
                val date = DateInput().read()
                taskRepository.update(task.withDeadline(task.deadline.withDate(date)))
            }

            TaskField.TIME -> {
                val time = TimeInput().read()
                taskRepository.update(task.withDeadline(task.deadline.withTime(time)))
            }

            TaskField.TASK -> {
                val titles = TaskTitlesInput().read()
                taskRepository.update(task.withTitles(titles))
            }
        }

        println("The task is changed")

        return true
    }
}
