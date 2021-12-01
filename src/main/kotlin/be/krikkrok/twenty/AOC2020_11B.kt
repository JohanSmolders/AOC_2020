package be.krikkrok.twenty

import be.krikkrok.BaseAoc

class AOC2020_11B : BaseAoc() {
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
        if (!isSame(seating, newSeating)) {
            println(newSeating.sumOf { chars ->
                chars.count { it == '#' }
            })
            computeNewSeating(newSeating)
        } else {
            println(newSeating.sumOf { chars ->
                chars.count { it == '#' }
            })
        }
    }

    private fun isSame(seating: List<CharArray>, newSeating: MutableList<CharArray>): Boolean {
        seating.forEachIndexed { row, chars ->
            chars.forEachIndexed { col, c ->
                if (c != newSeating[row][col]) {
                    return false
                }
            }
        }
        return true
    }

    private fun calculateForPosition(seating: List<CharArray>, row: Int, column: Int): Char {
        val seatsAround = arrayOf(
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.LEFT),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.RIGHT),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.DOWN),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.UP),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.LEFTDOWN),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.RIGHTDOWN),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.LEFTUP),
            currentIfExists(seating, row, column, SEAT_SEARCH_DIRECTION.RIGHTUP),
        )

        return when {
            seating[row][column] == '.' -> {
                '.'
            }
            seatsAround.none { it == '#' } -> {
                '#'
            }
            seatsAround.count { it == '#' } >= 5 -> {
                'L'
            }
            else -> {
                seating[row][column]
            }
        }
    }

    private fun currentIfExists(
        seating: List<CharArray>,
        row: Int,
        col: Int,
        seatSearchDirection: SEAT_SEARCH_DIRECTION
    ): Char {
        return try {
            val place = seating[row + seatSearchDirection.row][col + seatSearchDirection.col]
            if (place != '.') {
                place
            } else {
                currentIfExists(
                    seating,
                    row + seatSearchDirection.row,
                    col + seatSearchDirection.col,
                    seatSearchDirection
                )
            }
        } catch (e: Exception) {
            '.'
        }
    }

    enum class SEAT_SEARCH_DIRECTION(val row: Int, val col: Int) {
        UP(-1, 0),
        DOWN(+1, 0),
        LEFT(0, -1),
        RIGHT(0, +1),
        LEFTUP(-1, -1),
        RIGHTUP(-1, +1),
        LEFTDOWN(+1, -1),
        RIGHTDOWN(+1, +1)
    }
}

fun main() {
    AOC2020_11B()
}