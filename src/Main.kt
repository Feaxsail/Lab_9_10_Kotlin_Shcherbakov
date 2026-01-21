import payment.*
import outpost.*
import modules.ModuleResult

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("Успех: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.amount} ед. ${result.resourceName}")
        is ModuleResult.NotEnoughResources ->
            println("Не хватает ${result.resourceName}: нужно ${result.required}, есть ${result.available}")
        is ModuleResult.Error -> println("Ошибка: ${result.reason}")
    }
}

fun main() {
    // --- Платежи (оставляем) ---
    val processor = PaymentProcessor()
    val payments = listOf(
        Payment("1234567890123", 100.0, CardType.VISA),
        Payment("123", -50.0, CardType.MASTERCARD),
        Payment("1234567890123456", 200.0, CardType.MIR)
    )
    for (payment in payments) {
        processor.show(processor.pay(payment))
    }
    println()

    // --- Модули базы ---
    val generator = EnergyGenerator()
    val lab = ResearchLab()

    val genResult = generator.performAction()
    val labResult = lab.performAction()

    handleModuleResult(genResult)
    handleModuleResult(labResult)

    println()

    // --- Enum и data class (можно оставить или убрать) ---
    println("Типы карт: ${CardType.values().contentToString()}")
}