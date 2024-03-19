package tasklist.input

import tasklist.command.TaskListCommand

class CommandInput(
    private val commands: Map<String, TaskListCommand>
) {
    fun read(): TaskListCommand {
        println("Input an action (add, print, edit, delete, end):")
        val command = readln().lowercase()

        if (!commands.containsKey(command)) {
            println("The input action is invalid")
            return read()
        }

        return commands[command]!!
    }
}
