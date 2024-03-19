package tasklist.model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File

private const val TASK_LIST_JSON_FILE = "tasklist.json"

class JsonTaskStorage {

    fun save(tasks: List<Task>) {
        val json = jsonAdapter().toJson(tasks.map { task ->
            TaskDto(
                task.id,
                task.title,
                task.priority.value,
                TaskDeadlineDto(
                    task.deadline.dateString(),
                    task.deadline.timeString()
                ),
                task.subtasks
            )
        })

        File(TASK_LIST_JSON_FILE).writeText(json)
    }

    fun load(): List<Task> {
        val file = File(TASK_LIST_JSON_FILE)

        if (!file.exists()) {
            return emptyList()
        }

        val json = file.readText()
        val tasks = jsonAdapter().fromJson(json) ?: emptyList()

        return tasks.map { taskDto ->
            Task(
                taskDto.id,
                taskDto.title,
                TaskPriority.fromValue(taskDto.priority),
                TaskDeadline(
                    "${taskDto.deadline.date} ${taskDto.deadline.time}"

                ),
                taskDto.subtasks
            )
        }
    }

    private fun jsonAdapter(): JsonAdapter<List<TaskDto>> {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return moshi.adapter(Types.newParameterizedType(List::class.java, TaskDto::class.java))
    }
}
