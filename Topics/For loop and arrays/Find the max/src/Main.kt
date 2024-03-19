fun main() {
    val numbers = Array(readln().toInt()) { readln().toInt() }

    println(
        numbers.indexOf(
            numbers.find { it -> it == numbers.maxOf { it } }
        )
    )
}
