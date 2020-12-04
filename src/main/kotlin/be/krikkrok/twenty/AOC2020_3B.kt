package be.krikkrok.twenty

import be.krikkrok.BaseAoc

class AOC2020_3B : BaseAoc() {
    init {

        var item: ArrayList<ArrayList<Char>> = arrayListOf()
        var row = 0
        asReader("/2020/2020_3A.txt").forEachLine { line ->
            var col = 0
            item.add(arrayListOf())
            line.forEach {
                col
                item[row].add(it)
                col++
            }
            row++
        }

        var paths = arrayListOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
        var product = 1L

        var maxRow = item.size
        var maxCol = item[0].size
        paths.forEach { cor ->
            var trees = 0
            var currentRow = 0
            var currentCol = 0


            repeat((currentRow until item.size).count() - 1) {
                currentCol += cor.first
                currentRow += cor.second
                if (maxCol <= currentCol) {
                    currentCol -= maxCol
                }

                if (maxRow >= currentRow && item[currentRow][currentCol] == '#') {
                    trees++
                }
            }

            product *= trees
        }


        println("PRODUCT $product")
    }
}

fun main() {
    AOC2020_3B()
}