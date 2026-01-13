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
}