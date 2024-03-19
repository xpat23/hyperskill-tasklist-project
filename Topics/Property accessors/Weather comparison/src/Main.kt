class City(val name: String, defaultDegrees: Int) {
    var degrees: Int = defaultDegrees
        set(value) {
            if (value < 57 && value > -97) {
                field = value
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai", 30)
    firstCity.degrees = first
    val secondCity = City("Moscow", 5)
    secondCity.degrees = second
    val thirdCity = City("Hanoi", 20)
    thirdCity.degrees = third

    //implement comparing here
    val cities = listOf(firstCity,secondCity, thirdCity).sortedBy { it.degrees }
    if (cities.first().degrees == cities[1].degrees) {
        println("neither")
    } else {
        println(cities.first().name)
    }
}
