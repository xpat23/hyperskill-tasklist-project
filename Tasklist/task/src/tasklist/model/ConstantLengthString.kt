package tasklist.model

data class ConstantLengthString(private val string: String, private val length: Int) {

    fun extra(): String {
        val size = string.length - length

        return if (size > 0) string.takeLast(size) else ""
    }

    override fun toString(): String {
        if (string.length > length) {
            return string.take(length)
        }
        return string + " ".repeat(length - string.length)
    }
}
