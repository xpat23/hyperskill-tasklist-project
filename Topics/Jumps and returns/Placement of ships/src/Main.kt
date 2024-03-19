fun main() {
    val rows = 5
    val cols = 5

    val battlefield = Array(rows) { BooleanArray(cols) { false } }

    repeat(3) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        battlefield[x - 1][y - 1] = true
    }

    val emptyRows = mutableListOf<Int>()
    val emptyCols = mutableListOf<Int>()

    for (i in 0 until rows) {
        var rowEmpty = true
        var colEmpty = true

        for (j in 0 until cols) {
            if (battlefield[i][j]) {
                rowEmpty = false
            }
            if (battlefield[j][i]) {
                colEmpty = false
            }
        }

        if (rowEmpty) {
            emptyRows.add(i + 1)
        }

        if (colEmpty) {
            emptyCols.add(i + 1)
        }
    }

    println(emptyRows.joinToString(" "))
    println(emptyCols.joinToString(" "))
}
