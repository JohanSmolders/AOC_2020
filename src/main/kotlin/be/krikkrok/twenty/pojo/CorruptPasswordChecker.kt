package be.krikkrok.twenty.pojo

class CorruptPasswordChecker(private val lower: Int, private val higher: Int, private val letter: String, private val password: String) {

    fun isCorrect(): Boolean {
        val count = password.count { letter.contains(it) }

        return count in lower..higher
    }

    fun isCorrectPolicy2(): Boolean {
        return (
                        (password[lower - 1] == letter[0] && password[higher - 1] != letter[0])
                                ||
                                (password[lower - 1] != letter[0] && password[higher - 1] == letter[0])

                        )
    }
}