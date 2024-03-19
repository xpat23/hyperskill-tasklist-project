fun main() {
    val numbers = Array(readln().toInt()) { readln().toInt() }
    val number = readln().toInt()

    if (numbers.contains(number)) {
        println("YES")
    } else {
        println("NO")
    }
}
