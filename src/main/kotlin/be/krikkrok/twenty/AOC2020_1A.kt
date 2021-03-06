package be.krikkrok.twenty

import be.krikkrok.BaseAoc
import kotlin.system.exitProcess

class AOC2020_1A : BaseAoc() {
    init {
        var items = ArrayList<Int>()
        asReader("/2020/2020_1A.txt").forEachLine {
            items.add(it.toInt())
        }

        items.forEach { first ->
            items.forEach{ second ->
                if((first + second) == 2020){
                    val product = first * second
                    println("The answer is: $product")
                    exitProcess(0)
                }
            }
        }
    }
}

fun main() {
    AOC2020_1A()
}