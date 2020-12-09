package be.krikkrok.twenty.executors

import be.krikkrok.twenty.pojo.Operation

class Executor8B(val list: ArrayList<Operation>) {
    var accumulator = 0
    var visitedOperations = ArrayList<Int>()
    var currentPosition = 0

    fun getAccumulatorBeforeLoop(fixedList: List<Operation>): Int? {
        accumulator = 0
        visitedOperations = ArrayList()
        currentPosition = 0

        do{
            visitedOperations.add(currentPosition)
            when(fixedList[currentPosition].operation){
                "jmp" -> {
                    currentPosition += fixedList[currentPosition].value.toInt()
                }
                "nop" -> {
                    currentPosition++
                }
                "acc" -> {
                    accumulator += fixedList[currentPosition].value.toInt()
                    currentPosition++
                }
            }
        }while (!visitedOperations.contains(currentPosition) && fixedList.size > currentPosition)

        if(fixedList.size <= currentPosition){
            return accumulator
        }

        return null
    }

    fun fixProgramAndAccum(): Int {
        val indexesOfCommandToChange = list.mapIndexed { index, operation -> if(operation.operation == "jmp" || operation.operation == "nop") index else null }.filterNotNull()

        indexesOfCommandToChange.forEach {
            val fixedList = list.map { it.copy() }.toMutableList()
            val operation = fixedList[it]
            operation.operation = if(operation.operation == "nop") "jmp" else "nop"
            fixedList[it] = operation

            getAccumulatorBeforeLoop(fixedList)?.let { value ->
                return value
            }
        }

        return 0
    }
}