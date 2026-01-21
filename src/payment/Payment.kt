package payment

sealed class PaymentResult {
    data class Success(val transactionId: String) : PaymentResult()
    data class Error(val reason: String) : PaymentResult()
    object Processing : PaymentResult()
}

enum class CardType {
    VISA, MASTERCARD, MIR
}

data class Payment(
    val cardNumber: String,
    val amount: Double,
    val cardType: CardType
)