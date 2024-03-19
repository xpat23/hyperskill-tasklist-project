package tasklist.model

enum class TaskField(
    val value: String
) {
    DATE("date"),
    TIME("time"),
    PRIORITY("priority"),
    TASK("task");

    companion object {
        fun fromValue(value: String): TaskField {
            return when (value) {
                "date" -> DATE
                "time" -> TIME
                "priority" -> PRIORITY
                "task" -> TASK
                else -> throw IllegalArgumentException()
            }
        }
    }
}
