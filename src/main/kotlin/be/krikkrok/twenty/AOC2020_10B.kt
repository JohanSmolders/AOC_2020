package be.krikkrok.twenty

import be.krikkrok.BaseAoc

class AOC2020_10B : BaseAoc() {
    init {
        val list = asIntList("/2020/2020_10A.txt") as ArrayList

        val allParts= ArrayList<ArrayList<Int>> ()
        var currentList = ArrayList<Int>()
        allParts.add(currentList)

        list.sorted().windowed(2, 1) {
            when(it[1] - it[0]){
                3 -> {
                    currentList.add(it[0])
                    currentList = ArrayList<Int>()
                    allParts.add(currentList)
                }
                2 -> {
                    throw NotImplementedError("2 jolt spike")
                }
                else -> {
                    currentList.add(it[0])
                }
            }
        }
        currentList.add(list.maxOrNull()!!)

        var totalOptions = 1L

        //There don't seem to be any 2 jolt steps so
        allParts.map {
            when(it.size){
                1 -> 1
                2 -> 1
                3 -> 2
                4 -> 4
                5 -> 6
                else -> throw NotImplementedError()
            }
        }.forEach { it ->
            totalOptions *= it
        }

        println(totalOptions)
    }
}

fun main() {
    AOC2020_10B()
}