package payment

class PaymentProcessor {
    fun pay(payment: Payment): PaymentResult {
        if (!PaymentValidator.validate(payment)) {
            return PaymentResult.Error("Некорректные данные платежа")
        }

        return when (payment.cardType) {
            CardType.VISA -> PaymentResult.Success("VISA-${System.currentTimeMillis()}")
            CardType.MASTERCARD -> PaymentResult.Success("MC-${System.currentTimeMillis()}")
            CardType.MIR -> PaymentResult.Processing
        }
    }

    fun show(result: PaymentResult) {
        when (result) {
            is PaymentResult.Success -> println("Платёж успешен. ID: ${result.transactionId}")
            is PaymentResult.Error -> println("Ошибка платежа: ${result.reason}")
            PaymentResult.Processing -> println("Платёж в обработке...")
        }
    }
}