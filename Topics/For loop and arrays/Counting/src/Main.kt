fun main() {
    val numbers = Array(readln().toInt()) { readln().toInt() }
    val number = readln().toInt()

    println(numbers.fold(0) { acc, i -> if (number == i) acc + 1 else acc})
}
