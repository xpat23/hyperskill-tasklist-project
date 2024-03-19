package tasklist.command

import tasklist.model.JsonTaskStorage
import tasklist.model.TaskRepository

class TaskListExitingCommand(private val taskStorage: JsonTaskStorage, private val taskRepository: TaskRepository) :
    TaskListCommand {
    override fun execute(): Boolean {
        println("Tasklist exiting!")
        taskStorage.save(taskRepository.findAll())
        return false
    }
}
