package tasklist.output

import tasklist.model.ConstantLengthString
import tasklist.model.Task

private const val TITLE_LENGTH = 44

class TaskListPrinter(private val tasks: List<Task>) {
    fun print() {
        println("+----+------------+-------+---+---+--------------------------------------------+")
        println("| N  |    Date    | Time  | P | D |                   Task                     |")
        println("+----+------------+-------+---+---+--------------------------------------------+")
        tasks.forEach { it ->

            val title = ConstantLengthString(it.title, TITLE_LENGTH)
            println("| ${it.id}  | ${it.deadline.dateString()} | ${it.deadline.timeString()} | ${it.priority.color} | ${it.deadline.dueTagColor()} |$title|")


            for (str in title.extra().chunked(TITLE_LENGTH)) {
                println("|    |            |       |   |   |${ConstantLengthString(str, TITLE_LENGTH)}|")
            }


            it.subtasks.forEach {
                val subtaskTitle = ConstantLengthString(it, TITLE_LENGTH)

                println("|    |            |       |   |   |$subtaskTitle|")

                for (str in subtaskTitle.extra().chunked(TITLE_LENGTH)) {
                    println("|    |            |       |   |   |${ConstantLengthString(str, TITLE_LENGTH)}|")
                }
            }

            println("+----+------------+-------+---+---+--------------------------------------------+")
        }
    }
}
