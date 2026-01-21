package payment

fun main() {

    val processor = PaymentProcessor()

    val payments = listOf(
        Payment("1234567890123", 100.0, CardType.VISA),
        Payment("123", -50.0, CardType.MASTERCARD),
        Payment("1234567890123456", 200.0, CardType.MIR)
    )

    for (payment in payments) {
        val result = processor.pay(payment)
        processor.show(result)
    }
    println()
    println("Доступные типы карт:")
    for (type in CardType.values()) {
        println("- $type")
    }
    println()

    val p1 = Payment("1111", 100.0, CardType.VISA)
    val p2 = p1.copy(amount = 150.0)
    println("p1: $p1")
    println("p2 (копия с изменением): $p2")
    println("p1 == p2: ${p1 == p2}")
}