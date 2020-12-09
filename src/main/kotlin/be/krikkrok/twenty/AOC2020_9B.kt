package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.twenty.executors.Executor8A
import be.krikkrok.twenty.extentions.sumByLong
import be.krikkrok.twenty.pojo.Bag
import be.krikkrok.twenty.pojo.Operation
import kotlin.system.exitProcess


class AOC2015_9B : BaseAoc() {

    val totalPreamble = ArrayList<Long>()
    val preamble = ArrayList<Long>()
    val preambleLength = 25
    init {
        asReader("/2020/2020_9A.txt").forEachLine { line ->
            if(preamble.size < preambleLength){
                preamble.add(line.toLong())
                totalPreamble.add(line.toLong())
            }else{
                if(preamble.filter { first -> preamble.filter { second ->  first != second && (first + second) == line.toLong()  }.count() > 0 }.count() == 0){
                    searchContiguousSet(line.toLong())
                }else{
                    preamble.remove(preamble [0])
                    preamble.add(line.toLong())
                    totalPreamble.add(line.toLong())
                }
            }
        }



    }

    private fun searchContiguousSet(toLong: Long) {
        (2..99).forEach { windowSize ->
            totalPreamble.windowed(windowSize).filter { list ->
                list.sumByLong { it } == toLong
            }.firstOrNull()?.let {
                println(it.minOf { it } + it.maxOf { it })
                exitProcess(0)
            }
        }
    }
}

fun main() {
    AOC2015_9B()
}
