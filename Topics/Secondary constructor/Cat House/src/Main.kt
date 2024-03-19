class Kitty(
    val color: String,
    val age: Int
) {
    constructor(age: Int, color: String) : this(color, age)
    constructor(age: Int) : this(age, "Black")
    constructor(color: String) : this(3, color)
}
