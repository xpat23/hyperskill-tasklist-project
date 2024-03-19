package tasklist.model

class TaskRepository(private var tasks: MutableList<Task> = mutableListOf()) {

    private var nextId = 1

    fun getById(id: Int): Task {
        return tasks.find { it.id == id }!!
    }

    fun nextId(): Int {
        return nextId++
    }

    fun add(task: Task) {
        tasks.add(task)
    }

    fun delete(task: Task) {
        tasks.remove(task)
        refreshIds()
    }

    private fun refreshIds() {
        tasks = tasks.mapIndexed { index, task -> task.withId(index + 1) }.toMutableList()
    }

    fun update(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = task
        }
    }

    fun findAll(): List<Task> {
        return tasks.toList()
    }
}
