package be.krikkrok.twenty

import be.krikkrok.BaseAoc

class AOC2020_11A : BaseAoc() {
    init {


        var seating = asStringList("/2020/2020_11A.txt").map {
            it.toCharArray()
        }

        computeNewSeating(seating)

    }

    private fun computeNewSeating(seating: List<CharArray>) {
        val newSeating = ArrayList<CharArray>()
        seating.forEach {
            newSeating.add(it.toMutableList().toCharArray())

        }

        seating.forEachIndexed { row, chars ->
            chars.forEachIndexed { column, c ->
                newSeating[row][column] = calculateForPosition(seating, row, column)
            }
        }
        if(!isSame(seating, newSeating)){
            println(newSeating.sumOf { chars ->
                chars.count { it == '#' }
            })
            computeNewSeating(newSeating)
        }else{
            println(newSeating.sumOf { chars ->
                chars.count { it == '#' }
            })
        }
    }

    private fun isSame(seating: List<CharArray>, newSeating: MutableList<CharArray>): Boolean {
        seating.forEachIndexed{ row, chars ->
            chars.forEachIndexed{col, c ->
                if(c != newSeating[row][col]){
                    return false
                }
            }
        }
        return true
    }

    private fun calculateForPosition(seating: List<CharArray>, row: Int, column: Int): Char {
        val seatsAround = arrayOf(
            currentIfExists(seating, row - 1, column),
            currentIfExists(seating, row + 1, column),
            currentIfExists(seating, row, column + 1),
            currentIfExists(seating, row, column - 1),
            currentIfExists(seating, row - 1, column - 1),
            currentIfExists(seating, row + 1, column + 1),
            currentIfExists(seating, row + 1, column - 1),
            currentIfExists(seating, row - 1, column + 1)
        )

        return when {
            seating[row][column] == '.' -> {
                '.'
            }
            seatsAround.none { it == '#' } -> {
                '#'
            }
            seatsAround.count { it == '#' } >= 4 -> {
                'L'
            }
            else -> {
                seating[row][column]
            }
        }
    }

    private fun currentIfExists(seating: List<CharArray>, row: Int, column: Int): Char {
        return try {
            seating[row][column]
        } catch (e: Exception) {
            '.'
        }
    }
}

fun main() {
    AOC2020_11A()
}