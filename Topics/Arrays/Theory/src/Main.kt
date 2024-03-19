fun main() {
    for (i in 1..4) {
        loop1@ for (j in 1..3) {
            for (k in 1..2) {
                if (i == 2 || j == 3 || k == 2) break@loop1
                print("$k")
            }
        }
    }
}

