fun main(args: Array<String>) {
    val bowser = Animal("Bowser", 20.0, 13.5)
    bowser.getInfo()

    val pontus = Dog("Pontus", 10.4, 1.3, "Gina")
    pontus.getInfo()
}

fun getSum(vararg nums : Int) : Int {
    var sum = 0
    nums.forEach { n -> sum += n }
    return sum
}

open class Animal(val name : String, var height : Double, var weight : Double) {
    init {
        val regex = Regex(".\\d+.*")
        require(!name.matches(regex)) { "Animal name cant contain numbers" }
        require(height > 0) {"height must be more than 0"}
    }

    open fun getInfo(): Unit {
        println("$name is $height tall and weighs $weight")
    }
}

class Dog(name : String, height : Double, weight : Double, var owner : String) :
        Animal(name, height, weight) {
    override fun getInfo() {
        super.getInfo()
        print(" and is owned by $owner")
    }
}

interface Flyable {
    var flies : Boolean
    fun fly(distMile: Double) : Unit
}

class Bird constructor(val name: String,
                       override var flies : Boolean = true) : Flyable  {
    override fun fly(distMile: Double) {
        TODO("Not yet implemented")
    }
}




