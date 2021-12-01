package be.krikkrok.twenty

import be.krikkrok.BaseAoc

class AOC2020_10B : BaseAoc() {
    init {
        val list = asIntList("/2020/2020_10A.txt") as ArrayList

        list.add(0)

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
                else -> {
                    currentList.add(it[0])
                }
            }
        }
        currentList.add(49)

        var totalOptions = 1L

        //There don't seem to be any 2 jolt steps so, we maps the known sequences to their permutations
        allParts.map {
            when(it.size){
                1 -> 1
                2 -> 1
                3 -> 2
                4 -> 4
                5 -> 7
                else -> 0
            }
        }.forEach { it ->
            println(totalOptions)
            totalOptions *= it
        }

        println(totalOptions)
    }
}

fun main() {
    AOC2020_10B()
}

