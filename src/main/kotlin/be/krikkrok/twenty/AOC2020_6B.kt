package be.krikkrok.fifteen

import be.krikkrok.BaseAoc


class AOC2015_6B : BaseAoc() {
    init {
        val groups = ArrayList<List<Char>>()


        var currentGroup: List<Char> = ArrayList()
        var first = true
        asReader("/2020/2020_6A.txt").forEachLine { command ->
            if(command == ""){
                groups.add(currentGroup)
                currentGroup = ArrayList()
                first = true
            }else{
                if(first){
                    command.toCharArray().forEach { (currentGroup as MutableList).add(it) }
                }else{
                    currentGroup = currentGroup.intersect(command.toCharArray().asList()).toList()
                }

                first = false

            }
        }
        groups.add(currentGroup)

        println(groups.sumBy { it.distinct().count() })
    }
}

fun main() {
    AOC2015_6B()
}