package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.twenty.executors.Executor8A
import be.krikkrok.twenty.executors.Executor8B
import be.krikkrok.twenty.pojo.Bag
import be.krikkrok.twenty.pojo.Operation


class AOC2015_8B : BaseAoc() {


    val ops = ArrayList<Operation>()
    init {
        asReader("/2020/2020_8A.txt").forEachLine { line ->
            val split = line.split(" ")
            ops.add(Operation(split[0].trim(), split[1].trim()))
        }

        println(Executor8B(ops).fixProgramAndAccum())



    }
}

fun main() {
    AOC2015_8B()
}
