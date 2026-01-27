
import kotlin.properties.Delegates

class SystemLogger {
    init {
        println("Система логирования инициализирована")
    }
    fun log(message: String) {
        println("LOG: $message")
    }
}

val logger by lazy { SystemLogger() }

fun main() {
    // Загрузка состояния
    val loadedResources = FileStorage.load()
    val manager = ResourceManager()
    loadedResources.forEach { manager.add(it) }

    if (loadedResources.isEmpty()) {
        manager.add(OutpostResource(id = 1, name = "Minerals", amountInit = 300))
        manager.add(OutpostResource(id = 2, name = "Gas", amountInit = 100))
    }

    // Использование логгера
    logger.log("Приложение запущено")

    // Изменение ресурса
    val minerals = manager.getAll().find { it.name == "Minerals" }
    minerals?.amount = 350

    // Сохранение состояния
    FileStorage.save(manager.getAll())
}