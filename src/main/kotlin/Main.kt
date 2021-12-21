import java.util.*

class Account(val depot: Int){
    var balance: Int = depot

    fun retrieveMoney(value: Int){
        if(balance > 0 && value < balance){
            var solde: Int = this.balance-value
            println("A la date du : ${Date().toLocaleString()}, Vous avez retiré ${value} €, il vous reste ${solde}€ sur votre compte")
        }else{
            println("A la date du : ${Date().toLocaleString()}, votre solde de compte est insuffisant !")
        }
    }
    fun AddMoney(value: Int){
        var newSolde: Int = this.balance + value
        println("A la date du : ${Date().toLocaleString()}, Après un dépot de $value€, il vous reste maintenant $newSolde€ sur votre compte")
    }
}
 var BrunoAccount = Account(50)
var EnzoAccount = Account(100)

fun main(){
    BrunoAccount.retrieveMoney(60)
    EnzoAccount.retrieveMoney(20)
    BrunoAccount.AddMoney(50)

}