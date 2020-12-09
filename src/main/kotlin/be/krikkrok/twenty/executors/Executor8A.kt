package be.krikkrok.twenty.executors

import be.krikkrok.twenty.pojo.Operation

class Executor8A(val list: ArrayList<Operation>) {
    var accumulator = 0
    var visitedOperations = ArrayList<Int>()
    var currentPosition = 0

    fun getAccumulatorBeforeLoop(): Int {

        do{
            visitedOperations.add(currentPosition)
            when(list[currentPosition].operation){
                "jmp" -> {
                    currentPosition += list[currentPosition].value.toInt()
                }
                "nop" -> {
                    currentPosition++
                }
                "acc" -> {
                    accumulator += list[currentPosition].value.toInt()
                    currentPosition++
                }
            }
        }while (!visitedOperations.contains(currentPosition))
        return accumulator
    }
}