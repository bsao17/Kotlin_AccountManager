import java.util.*


interface CurrentAccountActions {
    fun retrieveMoney(value: Int)
    fun addMoney(value: Int)
    fun readAccount()
}

interface ProfessionalAccount {
    fun retrieveMoney(value: Int)
    fun addMoney(value: Int)
    fun readAccount()
    fun overdraftPossibilities(value: Int)
}

class CurrentAccount(depot: Int): CurrentAccountActions{
    var balance: Int = depot

    override fun retrieveMoney(value: Int) {
        if (balance > 0 && value < balance) {
            var solde: Int = this.balance - value
            println("A la date du : ${Date().toLocaleString()}, Vous avez retiré ${value} €, il vous reste ${solde}€ sur votre compte")
        } else {
            println("A la date du : ${Date().toLocaleString()}, votre solde de compte est insuffisant !")
        }
    }

    override fun addMoney(value: Int) {
        var newSolde: Int = this.balance + value
        println("A la date du : ${Date().toLocaleString()}, Après un dépot de $value€, il vous reste maintenant $newSolde€ sur votre compte")
    }

    override fun readAccount() {
        println("A la date du : ${Date().toLocaleString()}, le solde de votre compte est de $balance€ ")
    }
}


var BrunoAccount = CurrentAccount(50)
var EnzoAccount = CurrentAccount(100)

fun main() {
    BrunoAccount.retrieveMoney(60)
    EnzoAccount.retrieveMoney(20)
    BrunoAccount.addMoney(50)
    BrunoAccount.readAccount()

}