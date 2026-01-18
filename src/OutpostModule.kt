abstract class OutpostModule(
    val name: String,
    var level: Int = 1
) {
    fun upgrade() {
        level++
        println("Модуль $name повышен до уровня $level")
    }

    abstract fun performAction(manager: ResourceManager)
}