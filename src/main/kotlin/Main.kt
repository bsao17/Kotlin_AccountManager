fun main() {
    var firstname: String = "Bruno"
    println(firstname)

    fun entryAge(age: Int) {
        when (age) {
            in 0..18 -> println("Too young, don't enter !!!")
            in 18..60 -> println("It's okay, you can enter in discotheque")
            in 60..1000 -> println("Ohhh Too old, come back when you should be young again !!!")
        }
    }

    entryAge(14)
    Enzo.getAge()
    Bruno.getAge()
}

class Person(age: Number) {
    private var itAge: Number = age

    fun getAge() {
        println(itAge)
    }
}

val Enzo = Person(17)
val Bruno = Person(47)