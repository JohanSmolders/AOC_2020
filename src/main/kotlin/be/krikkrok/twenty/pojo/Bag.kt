package be.krikkrok.twenty.pojo

class Bag(val color: String, val amount: Int, val contents: List<Bag>) {
    fun containsGoldBag(allBags: List<Bag>)
            : Boolean {
        return when {
            color == "shiny gold" -> {
                true
            }
            contents.isEmpty() -> {
                false
            }
            else -> {
                return contents.map { it.color }
                    .filter { searchColor -> allBags.first { it.color == searchColor }.containsGoldBag(allBags) }
                    .count() > 0

            }
        }

    }

    fun countBagsWithin(allBags: List<Bag>): Int {
        return when {
            contents.isEmpty() -> {
                0
            }
            else -> {
                contents.sumBy { content ->
                    content.amount + (content.amount * allBags.first { it.color == content.color }
                        .countBagsWithin(allBags))
                }
            }
        }
    }

    override fun toString(): String {
        return "$color $amount "
    }
}