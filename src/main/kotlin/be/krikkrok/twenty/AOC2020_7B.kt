package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.twenty.pojo.Bag

class AOC2015_7B : BaseAoc() {

    init {
        val availableBags: ArrayList<Bag> = ArrayList()
        asReader("/2020/2020_7A.txt").forEachLine { line ->
            val color = line.substring(0, line.indexOf("bags") - 1)
            val contentsOfBag =
                line.substring(line.indexOf("contain") + 7, line.indexOf(".")).split(",").map { it.trim() }
            val contentsOfBagAsBag =
                if (contentsOfBag[0].startsWith("no other bags")) {
                    emptyList()
                } else {
                    contentsOfBag.map { bag ->
                        val amount = bag.substring(0, bag.indexOf(" "))
                        val color = bag.substring(bag.indexOf(" "), bag.indexOf("bag")).trim()
                        Bag(color, amount.toInt(), emptyList())
                    }
                }
            availableBags.add(Bag(color, 1, contentsOfBagAsBag))
        }

        println((availableBags.filter { it.color == "shiny gold" }.map { it.countBagsWithin(availableBags) }))

    }
}

fun main() {
    AOC2015_7B()
}