package tasklist.model

enum class TaskPriority(
    val value: String
) {
    CRITICAL("C"),
    HIGH("H"),
    Normal("N"),
    LOW("L");

    companion object {
        fun fromValue(value: String): TaskPriority {
            return when (value) {
                "C" -> CRITICAL
                "H" -> HIGH
                "N" -> Normal
                "L" -> LOW
                else -> throw IllegalArgumentException()
            }
        }
    }

    val color = when (this.value) {
        "C" -> "\u001B[101m \u001B[0m"
        "H" -> "\u001B[103m \u001B[0m"
        "N" -> "\u001B[102m \u001B[0m"
        "L" -> "\u001B[104m \u001B[0m"
        else -> throw IllegalArgumentException()
    }
}
