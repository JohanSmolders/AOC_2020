package be.krikkrok.twenty

import be.krikkrok.BaseAoc
import be.krikkrok.twenty.pojo.CorruptPasswordChecker

class AOC2020_3A : BaseAoc() {
    init {

        var item: ArrayList<ArrayList<Char>> = arrayListOf()
        var row = 0
        asReader("/2020/2020_3A.txt").forEachLine { line ->
            var col = 0
            item.add(arrayListOf())
            line.forEach { col
                  item[row].add(it)
                col ++
            }
            row ++
        }

        var currentRow = 0
        var currentCol = 0
        var trees = 0
        var maxCol = item[0].size

        repeat((currentRow until item.size).count() - 1) {
            currentRow++
            currentCol += 3
            if (maxCol <= currentCol) {
                currentCol -= maxCol
            }

            if (item[currentRow][currentCol] == '#') {
                trees++
            }
        }

        println("Trees $trees")
    }
}

fun main() {
    AOC2020_3A()
}