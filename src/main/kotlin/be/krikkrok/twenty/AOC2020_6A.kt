package be.krikkrok.fifteen

import be.krikkrok.BaseAoc


class AOC2015_6A : BaseAoc() {

    init {
        val groups = ArrayList<ArrayList<Char>>()

        var currentGroup = ArrayList<Char>()
        asReader("/2020/2020_6A.txt").forEachLine { command ->
            if(command == ""){
                groups.add(currentGroup)
                currentGroup = ArrayList<Char>()
            }else{
                command.toCharArray().forEach { currentGroup.add(it) }
            }
        }
        groups.add(currentGroup)

        println(groups.sumBy { it.distinct().count() })
    }
}

fun main() {
    AOC2015_6A()
}