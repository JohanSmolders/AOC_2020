package be.krikkrok.twenty.pojo

class Passport{
    var byr: String? = null
    var iyr: String? = null
    var eyr: String? = null
    var hgt: String? = null
    var hcl: String? = null
    var ecl: String? = null
    var pid: String? = null
    var cid: String? = null

    fun setValue(name: String, value: String){
        when(name){
            "byr" -> byr = value
            "iyr" -> iyr = value
            "eyr" -> eyr = value
            "hgt" -> hgt = value
            "hcl" -> hcl = value
            "ecl" -> ecl = value
            "pid" -> pid = value
            "cid" -> cid = value
            else -> {
                println("Found unmappable property: $name")}
        }
    }

    fun isValid(): Boolean {
        return byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null
    }

    fun isValidExtra(): Boolean{
        return byrValid() && iyrValid() && eyrValid() && hgtValid() && hclValid() && eclValid() && pidValid()
    }

    private fun pidValid(): Boolean {
        return pid != null && pid!!.matches(Regex("\\d{9}"))
    }

    private fun eclValid(): Boolean {
        return ecl != null && listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(ecl!!)
    }

    private fun hclValid(): Boolean {
        return hcl != null && hcl!!.matches(Regex("#[A-Fa-f0-9]{6}"))
    }

    private fun hgtValid(): Boolean {
        if(hgt == null) {
            return false
        }
        val hgtWithout = hgt!!.replace("in", "").replace("cm", "")
        if(hgtWithout.matches(Regex("\\d?"))){
            return false
        }
        return (hgt!!.endsWith("in") && hgtWithout.toInt() >= 59 && hgtWithout.toInt() <= 76)
                ||  (hgt!!.endsWith("cm") && hgtWithout.toInt() >= 150 && hgtWithout.toInt() <= 193)
    }

    private fun eyrValid(): Boolean = validateYearLowerAndUpperBound(eyr, 2020, 2030)
    private fun iyrValid(): Boolean = validateYearLowerAndUpperBound(iyr, 2010, 2020)
    private fun byrValid(): Boolean = validateYearLowerAndUpperBound(byr, 1920, 2002)


    private fun validateYearLowerAndUpperBound(
        check: String?,
        lower: Int,
        upper: Int
    ) = check != null && check!!.matches(Regex("\\d{4}")) && check!!.toInt() >= lower && check!!.toInt() <= upper
}