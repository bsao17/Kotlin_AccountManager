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
        println("A la date du : ${Date().toLocaleString()}, le solde de votre compte est de ${this.balance}€ ")
    }
}

// Professional Account
class ProfessionalAccount(depot: Int) : CurrentAccount(depot), ProfessionalAccountActions {
    private var balance: Int = depot
    private var overdraft: Int = 0

    override fun retrieveMoney(value: Int) {
        if (value < overdraft) {
            var solde: Int = this.balance - value
            println(
                "A la date du : ${Date().toLocaleString()}, Vous avez retiré ${value} €, il vous reste ${solde}€ " +
                        "sur votre compte"
            )
        } else {
            println("A la date du : ${Date().toLocaleString()}, votre solde de compte est insuffisant !")
        }
    }

    override fun readAccount() {
        println("A la date du : ${Date().toLocaleString()}, le solde de votre compte professionnel est de ${this.balance}€ ")
    }

    override fun overdraftPossibilities(value: Int) {
        overdraft = balance - value
        println(overdraft)
    }
}


var BrunoAccount = CurrentAccount(900)
var EnzoAccount = CurrentAccount(200)
var FreelanceBrunoMehddeb = ProfessionalAccount(1000)


fun main() {
    BrunoAccount.addMoney(50)
    BrunoAccount.readAccount()
    EnzoAccount.readAccount()
    FreelanceBrunoMehddeb.readAccount()
    FreelanceBrunoMehddeb.overdraftPossibilities(3000)
    FreelanceBrunoMehddeb.readAccount()
    FreelanceBrunoMehddeb.retrieveMoney(2000)
}