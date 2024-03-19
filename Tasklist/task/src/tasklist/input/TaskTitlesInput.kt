package tasklist.input

class TaskTitlesInput {

    private val titles = mutableListOf<String>()

    private fun readTitles() {
        val title = readln()
        if (title.trim().isNotEmpty()) {
            titles.add(title)
            readTitles()
        }
    }

    fun read(): List<String> {
        println("Input a new task (enter a blank line to end):")
        readTitles()
        return titles
    }
}
