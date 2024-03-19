package tasklist.input

import tasklist.model.Task
import tasklist.model.TaskRepository

class TaskInput(
    private val priorityInput: TaskPriorityInput,
    private val deadlineInput: TaskDeadlineInput,
    private val titlesInput: TaskTitlesInput,
    private val taskRepository: TaskRepository
) {


    fun read(): Task? {

        val priority = priorityInput.read()
        val deadline = deadlineInput.read()
        val titles = titlesInput.read()

        if (titles.isEmpty()) {
            println("The task is blank")
            return null
        }

        return Task(
            taskRepository.nextId(),
            titles,
            priority,
            deadline
        )
    }
}
