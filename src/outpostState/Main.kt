package outpostState



fun main() {
    val manager by lazy {
        println("Менеджер ресурсов инициализирован")
        OutpostManager()
    }

    val observer = ResourceObserver()

    // Загрузка
    val loaded = StateStorage.load()
    if (loaded.isNotEmpty()) {
        loaded.forEach { manager.addResource(it) }
    } else {
        manager.addResource(ObservableResource("Minerals", 100))
        manager.addResource(ObservableResource("Gas", 50))
    }

    // Изменение
    manager.resources.forEach {
        it.amount += 20
        observer.onResourceChanged(it, it.amount - 20, it.amount)
    }

    // Сохранение
    StateStorage.save(manager.resources)
}