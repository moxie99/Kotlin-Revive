import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle
import kotlin.math.sqrt

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val intMinValue = Int.MIN_VALUE
    val intMaxValue = Int.MAX_VALUE
    val byteMaxValue = Byte.MAX_VALUE
    val byteMinValue = Byte.MIN_VALUE
    val shortMaxValue = Short.MAX_VALUE
    val shortMinValue = Short.MIN_VALUE
    val longMaxValue = Long.MAX_VALUE
    val longMinValue = Long.MIN_VALUE
    val age = 21
    val text = if (age == 22) "Age is 22" else 4
    val numbers = listOf<String>("one", "two", "three", "four", "five", "six")
//    println(numbers.slice(1..3))
//    println(numbers.slice(0..4 step 2))
//    println(numbers.slice(setOf(3,5,0)))

//    println(numbers.take(1))
//    println(numbers.takeLast(3))
//    println(numbers.drop(1))
//    println(numbers.dropLast(5))

//    println("\n")
//    println(numbers.takeWhile { it != "three" })
//    println(numbers.takeWhile { it.startsWith('s') })
//    println(numbers.takeWhile { it.endsWith('x') })
//    println(numbers.takeWhile { !it.startsWith('s') })

//    println("Integer max value is $intMaxValue and integer min value is $intMinValue")

    val names = arrayOf("David", "Daniel", "Dasola")
    val car1 = Car("Tesla", "Model 3", "White", 4)

//    collectionsFunc()
//    collectionTwo()

//    println(searchEl(15, mutableListOf(1,2,3,4,5,6,7,8,9,10,12,13,45,12,15,45,17,29,34)))

    val footballPlayer1 = FootballPlayer("Haaland")
    val footballPlayer2 = FootballPlayer("Ramos")

    val basketballPlayer1 = BasketballPlayer("James")
    val basketballPlayer2 = BasketballPlayer("Curry")

    val team1 = Team<FootballPlayer>("Manchester City", mutableListOf(footballPlayer1, footballPlayer2))
    val team2 = Team<BasketballPlayer>("Lakers", mutableListOf(basketballPlayer1, basketballPlayer2))

    team1.addPlayers(FootballPlayer("Lennon"))

    val user: User? = null

    user?.run {
        println(lastName)
        println(firstName)
        println(age_s)
    }
}

class Team<T>(val name: String, val players: MutableList<T>) {
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${(player as Player).name} is already in the team ${this.name}")
        } else {
            players.add(player)
            println("Player: ${(player as Player).name} added to the team: ${this.name}")
        }
    }
}

open class Player(val name: String)

class FootballPlayer(name: String): Player(name)
class BasketballPlayer(name: String): Player(name)


fun getMax(a: Int, b: Int): Int {
    val max = if (a > b) a else b
    return max
}

fun sum(vararg  numbers: Int): Int {
    var total = 0
    for (number in numbers) {
        total += number
    }
    return total
}

fun sum(vararg  numbers: Double): Double {
    var total = 0.0
    numbers.forEach { total + it  }

    return total
}
fun evenSkip() {
     for (i in 10 downTo 1 step 2) {

     }
}

fun findMaxValue(numbers: Array<Int>): Int {
    var maxValue = numbers[0]

    numbers.forEach {
        if (maxValue < it) {
            maxValue = it
        }
    }
    return  maxValue
}

fun findMinValue(numbers: Array<Int>): Int {
    var minValue = numbers[0]

    numbers.forEach {
        if (minValue > it) {
            minValue = it
        }
    }
    return  minValue
}

class  Car(var name: String, var model: String, var color: String, var numDoors: Int) {
    fun move() {
        println("$name is moving")
    }
    fun stop() {
        println("$name pressed brake, and $name stopped")
    }
}

class Account(val accountName: String) {
    private var balance = 0
    private var transactions = mutableListOf<Int>()

    fun deposit(amount: Int) {
        if (amount > 0) {
            transactions.add(amount)
            balance += amount
        } else {
            println("Please enter amount greater than zero(0)")
        }
    }

    fun withdraw(amount: Int) {
        if (-amount < 0) {
            transactions.add(-amount)
            this.balance += -amount
            println("$amount withdrawn. Balance is not ${this.balance}")
        }  else if (-amount < 0 && this.balance > 0) {

        }
        else {
            println("Please enter a valid amount to withdraw")
        }
    }

    fun calcBalance(): Int {
        return this.balance
    }


}

fun collectionsFunc() {
    val names = listOf<String>("David", "Shegs")
    val age = mutableListOf<Int>(8,19,23, 89)
    age.add(21)
    age.forEach { print(it) }
    age.removeAt(1)

    val users =  mapOf<Int, String>( 1 to "Daniel", )
    val matriceBox = listOf(mutableListOf("Ademola", "Adeyele", ), mutableListOf("Daniel","David"))

    val flattenedVal = matriceBox.flatten()
    flattenedVal.forEach { print(it) }
}

fun collectionTwo() {
    val numList = (1 .. 100).toList()
    print(numList)
}

private fun searchEl(searchElement: Int, numbers: MutableList<Int>): Int {
    var low = 0
    var high = numbers.size - 1
    print( numbers.size - 1)
    while (low <= high) {
        var mid = (low + high) / 2
        val cmp = numbers[mid].compareTo(searchElement)
        println("cmp: $cmp")

        if (cmp < 0) {
            low = mid + 1
        } else if (cmp > 0) {
            low = mid -1
        } else {
            return numbers[mid]
        }
    }

    return -1
}

data class User(val firstName: String, val lastName: String, val age_s: Int)