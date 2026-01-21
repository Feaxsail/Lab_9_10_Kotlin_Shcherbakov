package payment

object PaymentValidator {
    fun validate(payment: Payment): Boolean {
        if (payment.amount <= 0) return false
        if (payment.cardNumber.length < 13 || payment.cardNumber.length > 19) return false
        return true
    }
}