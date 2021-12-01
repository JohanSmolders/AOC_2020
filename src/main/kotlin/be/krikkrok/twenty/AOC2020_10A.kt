package be.krikkrok.twenty

import be.krikkrok.BaseAoc

class AOC2020_10A : BaseAoc() {
    init {
        val list = asIntList("/2020/2020_10A.txt") as ArrayList

        list.add(0)

        var oneJolt = 0
        var threeJolt = 1 //Device build in adapter is a 3 jolt

        list.sorted().windowed(2, 1) {
            when(it[1] - it[0]){
                1 -> oneJolt++
                3 -> threeJolt++
                else -> null
            }
        }
        println(oneJolt  * threeJolt)
    }
}

fun main() {
    AOC2020_10A()
}