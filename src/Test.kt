var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 110))
            field = value
    }
data class Item(
    val id: Int,
    val name: String,
    val quantity: Int
){
    override fun toString(): String {
        return "ID:$id name:$name quantity:$quantity"

    }
}

abstract class Human(val name: String){
    abstract fun hello()
    abstract var age: Int
}

abstract class Figure {
    abstract fun perimeter(): Float

    abstract fun area(): Float
}

class Rectangle(val width: Float, val height: Float) : Figure() {
    override fun perimeter(): Float {
        return 2 * (width + height)
    }

    override fun area(): Float {
        return width * height
    }
}



class Person(name: String) : Human(name) {
    override var age: Int = 1
    override fun hello() {
        println("My name is $name")
    }
}
fun main() {
    println(age)
    age = 45
    println(age)
    age = -345
    println(age)
    val sword = Item(id = 1, name = "Sword", quantity = 1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())
    val(id, name, quantity) = betterSword
    println("ID:$id name:$name quantity:$quantity")
    val danil: Person = Person(name = "Danil")
    val pavel: Human = Person(name = "Pavel")

}