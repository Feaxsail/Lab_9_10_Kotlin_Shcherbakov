// example/GameHero.kt

import kotlin.properties.Delegates

class GameHero(startName: String) {
    var name: String by Delegates.observable(startName) { _, old, new ->
        println("Имя героя изменено: $old -> $new")
    }

    var mana: Int by Delegates.observable(100) { _, old, new ->
        println("Мана изменена: $old -> $new")
    }

    val ultimate: String by lazy {
        println("Загружаем анимацию способности...")
        "Санстрайк василича"
    }
}

fun main() {
    println("Создаём героя...")
    val hero = GameHero(startName = "Инвокер")

    println("\nТекущая мана: ${hero.mana}")

    println("\nГерой пытается использовать способность:")
    println("Способность: ${hero.ultimate}")

    println("\nПовторный вызов способности (должна быть мгновенной):")
    println("Способность: ${hero.ultimate}")

    println("\nМеняем имя героя:")
    hero.name = "Человек паук мэджки"

    println("\nГерой восстанавливает ману:")
    hero.mana = 200
}