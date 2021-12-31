package MoneyCount

@Suppress("UNUSED_EXPRESSION")
class Money(money: Float, month: Int = 12, day: Int = 18, hour: Int = 6) {
    private val money = money
    private val month = month
    private val day = day
    private val hour = hour
    private val abatement = (money * month * day * hour)/100

    fun oneDayGain(): String{
        return "CA pour une journée de ${hour} heures de travail en Freelance au TJM de ${money}€  = ${(money * hour)}"
    }
    fun monthGain(): String{
        return "CA pour un mois, soit ${day} jours de travail en Freelance au TJM de ${money}€  = ${money * day * hour}"
    }
    fun yearGain(): String{
        return "CA pour une année de ${month} mois de travail en Freelance\n au TJM de ${money}€ " +
                "avec abattement de 10% soit ${abatement}€  = ${(money * month * day * hour)} - ${abatement} " +
                " = ${(money * month * day * hour) - abatement}\n"

    }
}

val twoHundred = Money( 200.00F)
val threeHundred = Money(300.00F)
val fourHundred = Money(400.00F)
val fiveHundred = Money(500.00F)
val sixHundred = Money(600.00F)

fun main(){
    println(twoHundred.oneDayGain())
    println(twoHundred.monthGain())
    println(twoHundred.yearGain())

    println(threeHundred.oneDayGain())
    println(threeHundred.monthGain())
    println(threeHundred.yearGain())

    println(fourHundred.oneDayGain())
    println(fourHundred.monthGain())
    println(fourHundred.yearGain())

    println(fiveHundred.oneDayGain())
    println(fiveHundred.monthGain())
    println(fiveHundred.yearGain())

    println(sixHundred.oneDayGain())
    println(sixHundred.monthGain())
    println(sixHundred.yearGain())
}
