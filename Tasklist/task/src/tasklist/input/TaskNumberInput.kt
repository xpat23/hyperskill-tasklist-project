package tasklist.input

class TaskNumberInput(private val min: Int, private val max: Int) {
    fun read(): Int {
        println("Input the task number ($min-$max):")
        val number = readln().toIntOrNull()
        return if (number != null && number in min..max) {
            number
        } else {
            println("Invalid task number")
            read()
        }
    }
}
