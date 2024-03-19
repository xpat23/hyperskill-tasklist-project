package tasklist.command

import tasklist.input.*
import tasklist.model.TaskRepository

class AddTaskCommand(
    private val taskRepository: TaskRepository
) : TaskListCommand {

    override fun execute(): Boolean {
        val task = TaskInput(
            TaskPriorityInput(),
            TaskDeadlineInput(
                DateInput(),
                TimeInput()
            ),
            TaskTitlesInput(),
            taskRepository
        ).read()

        if (task != null) {
            taskRepository.add(task)
        }
        return true
    }
}
