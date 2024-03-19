package tasklist.model

class Task(
    val id: Int,
    val title: String,
    val priority: TaskPriority,
    val deadline: TaskDeadline,
    val subtasks: List<String>
) {

    fun withPriority(priority: TaskPriority): Task {
        return Task(id, title, priority, deadline, subtasks)
    }

    fun withDeadline(deadline: TaskDeadline): Task {
        return Task(id, title, priority, deadline, subtasks)
    }

    fun withTitles(titles: List<String>): Task {
        return Task(id, titles.first(), priority, deadline, titles.takeLast(titles.size - 1))
    }

    fun withId(id: Int): Task {
        return Task(id, title, priority, deadline, subtasks)
    }

    constructor(id: Int, titles: List<String>, priority: TaskPriority, deadline: TaskDeadline) : this(
        id,
        titles.first(),
        priority,
        deadline,
        titles.takeLast(titles.size - 1)
    )

}
