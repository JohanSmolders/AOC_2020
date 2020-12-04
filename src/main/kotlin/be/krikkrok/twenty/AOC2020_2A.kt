package be.krikkrok.twenty

import be.krikkrok.BaseAoc
import be.krikkrok.twenty.pojo.CorruptPasswordChecker

class AOC2020_2A : BaseAoc() {
    init {

        val passwords = ArrayList<CorruptPasswordChecker>()
        asReader("/2020/2020_2A.txt").forEachLine {
            val lower = it.substring(0, it.indexOf("-"))
            val higher = it.substring(it.indexOf("-") + 1, it.indexOf(" "))
            val letter = it.substring(it.indexOf(" ") + 1, it.indexOf(":"))
            val password = it.substring(it.indexOf(":") + 1)

            passwords.add(CorruptPasswordChecker(lower.toInt(), higher.toInt(), letter, password))
        }

        println(passwords.filter { it.isCorrect() }.count())
    }
}

fun main() {
    AOC2020_2A()
}