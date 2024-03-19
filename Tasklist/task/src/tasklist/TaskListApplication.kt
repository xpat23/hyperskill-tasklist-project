package tasklist

import tasklist.input.CommandInput

class TaskListApplication(private val commandInput: CommandInput) {

    fun run() {

        val command = commandInput.read()

        if (!command.execute()) {
            return
        }

        run()
    }
}
