package example

sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}

fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> println("Успех: ${result.data}")
        is NetworkResult.Error -> println("Ошибка ${result.code}: ${result.message}")
        NetworkResult.Loading -> println("Загрузка...")
    }
}

// --- Новое: OrderStatus ---
sealed class OrderStatus {
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}

fun handleOrder(status: OrderStatus) {
    when (status) {
        OrderStatus.Created -> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Заказ отменён: ${status.reason}")
    }
}

fun main() {
    // Закомментируем предыдущий main (NetworkResult)
    /*
    val success = NetworkResult.Success("Данные получены")
    val error = NetworkResult.Error("Сервер не отвечает", 500)
    val loading = NetworkResult.Loading

    handleResult(success)
    handleResult(error)
    handleResult(loading)
    */

    // Новый main: OrderStatus
    val created = OrderStatus.Created
    val paid = OrderStatus.Paid
    val shipped = OrderStatus.Shipped
    val cancelled = OrderStatus.Cancelled("Недостаточно средств")

    handleOrder(created)
    handleOrder(paid)
    handleOrder(shipped)
    handleOrder(cancelled)
}