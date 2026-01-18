package characters

class Hero(val name: String) {
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }

    val stamina: Int
        get() = 50 + 10 // Пример вычисляемого свойства

    var level: Int = 1
        private set

    fun levelUp() {
        level++
        println("$name повышает уровень: $level")
    }
}