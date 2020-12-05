package be.krikkrok.fifteen

import be.krikkrok.BaseAoc


class AOC2015_5B : BaseAoc() {

    enum class ArrayPart {
        FIRST,
        LAST
    }

    init {
        val rows = (0..127).map { it }.toIntArray()
        val cols = (0..7).map { it }.toIntArray()


        val seats = ArrayList<Int>()
        asReader("/2020/2020_5A.txt").forEachLine { command ->
            val row = command.substring(0, 7)
            var col = command.substring(7, 10)

            var currentRows = rows.copyOf()
            var currentCols = cols.copyOf()
            row.forEach {
                currentRows = if (it.toChar() == 'F') getArrayPart(ArrayPart.FIRST, currentRows) else getArrayPart(
                    ArrayPart.LAST,
                    currentRows
                )
            }

            col.forEach {
                currentCols = if (it.toChar() == 'L') getArrayPart(ArrayPart.FIRST, currentCols) else getArrayPart(
                    ArrayPart.LAST,
                    currentCols
                )
            }

            seats.add(currentRows[0] * 8 + currentCols[0])
        }

        (seats.minOf { it }..seats.maxOf { it }).forEach{ check ->
            if(!seats.contains(check)){
                println("Found $check")
            }
        }

    }

    private fun getArrayPart(arrayPart: ArrayPart, array: IntArray): IntArray {
        return if (arrayPart == ArrayPart.FIRST) {
            array.copyOfRange(0, array.size / 2)
        } else {
            array.copyOfRange(array.size / 2, array.size)
        }
    }
}

fun main() {
    AOC2015_5B()
}