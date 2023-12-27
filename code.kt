import java.awt.Desktop
import java.net.URI

abstract class Person(val name: String) {
    abstract fun greet()
}

interface FoodConsumer {
    fun eat()
    fun pay(amount: Int) = println("Delicious! Here's $amount bucks!")
}

class RestaurantCustomer(name: String, val dish: String) : Person(name), FoodConsumer {
    fun order() = println("$dish, please!")
    override fun eat() = println("*Eats $dish*")
    override fun greet() {
        println("Welcome to KOTLIN")
        println("I am $name, Founder at SKAV")
        println("Visit our website: skav-tech.mydurable.com")
        openWebsite("https://skav-tech.mydurable.com")
    }

    private fun openWebsite(url: String) {
        try {
            val desktop = Desktop.getDesktop()
            desktop.browse(URI(url))
        } catch (e: Exception) {
            println("Error opening the website: $e")
        }
    }
}

fun main() {
    val sandeep = RestaurantCustomer("Sandeep Kasturi", "Mixed salad")
    sandeep.greet()
    sandeep.order()
    sandeep.eat()
    sandeep.pay(10)
}
