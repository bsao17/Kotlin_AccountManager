import java.util.*


interface CurrentAccountActions {
    fun retrieveMoney(value: Int)
    fun addMoney(value: Int)
    fun readAccount()
}

interface ProfessionalAccountActions {
    fun overdraftPossibilities(value: Int)
}

// Current account
open class CurrentAccount(depot: Int) : CurrentAccountActions {
    private var balance: Int = depot
    override fun retrieveMoney(value: Int) {
        if (balance > 0 && value < balance) {
            var solde: Int = this.balance - value
            println(
                "A la date du : ${Date().toLocaleString()}, Vous avez retiré ${value} €, il vous reste ${solde}€ " +
                        "sur votre compte"
            )
        } else {
            println("A la date du : ${Date().toLocaleString()}, votre solde de compte est insuffisant !")
        }
    }

    override fun addMoney(value: Int) {
        var newSolde: Int = this.balance + value
        println(
            "A la date du : ${Date().toLocaleString()}, Après un dépot de $value€, il vous reste maintenant " +
                    "$newSolde€ sur votre compte"
        )
    }

    override fun readAccount() {
        println("A la date du : ${Date().toLocaleString()}, le solde de votre compte est de $balance€ ")
    }
}

// Professional Account
class ProfessionalAccount(depot: Int) : CurrentAccount(depot), ProfessionalAccountActions {
    private var balance: Int = depot

    override fun readAccount() {
        println("A la date du : ${Date().toLocaleString()}, le solde de votre compte professionnel est de $balance€ ")
    }

    override fun overdraftPossibilities(value: Int) {
        println("Would you really delete all ?")
    }
}


var BrunoAccount = CurrentAccount(900)
var EnzoAccount = CurrentAccount(200)
var FreelanceBrunoMehddeb = ProfessionalAccount(5000)


fun main() {
    BrunoAccount.addMoney(50)
    BrunoAccount.readAccount()
    EnzoAccount.readAccount()
    FreelanceBrunoMehddeb.addMoney(1000)
    FreelanceBrunoMehddeb.readAccount()
}