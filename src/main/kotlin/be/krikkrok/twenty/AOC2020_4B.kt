package be.krikkrok.twenty

import be.krikkrok.BaseAoc
import be.krikkrok.twenty.pojo.Passport

class AOC2020_4B : BaseAoc() {
    init {

        val list = ArrayList<Passport>()
        var current = Passport()
        asReader("/2020/2020_4A.txt").forEachLine { line ->
            if (line.isEmpty()) {
                list.add(current)
                current = Passport()
            }

            line.split(" ").forEach { keyValue ->
                val split = keyValue.split(":")
                if(split.size == 2){
                    current.setValue(split[0], split[1])
                }
            }
        }
        list.add(current)

        println(list.filter { it.isValidExtra() }.count())
    }
}

fun main() {
    AOC2020_4B()
}