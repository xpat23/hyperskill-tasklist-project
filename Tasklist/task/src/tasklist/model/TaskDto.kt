package tasklist.model

class TaskDto(
    val id: Int,
    val title: String,
    val priority: String,
    val deadline: TaskDeadlineDto,
    val subtasks: List<String>
)
