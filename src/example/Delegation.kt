

import kotlin.properties.Delegates

// 1. Базовое делегирование интерфейсов
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

// 2. Messenger и SmartPhone
interface Messenger {
    fun send(message: String)
}

class InstantMessenger : Messenger {
    override fun send(message: String) {
        println("Отправляем сообщение: $message")
    }
}

class SmartPhone(private val m: Messenger) : Messenger by m

// 3. Множественное делегирование
interface PhotoDevice {
    fun takePhoto()
}

class PhotoCamera : PhotoDevice {
    override fun takePhoto() {
        println("Фото сделано")
    }
}

class SmartPhone2(
    private val m: Messenger,
    private val p: PhotoDevice
) : Messenger by m, PhotoDevice by p

// 4. Переопределение функций
interface Messenger2 {
    fun sendTextMessage()
    fun sendVoiceMessage()
}

class InstantMessenger2 : Messenger2 {
    override fun sendTextMessage() {
        println("Отправляем текстовое сообщение")
    }
    override fun sendVoiceMessage() {
        println("Отправляем голосовое сообщение")
    }
}

class SmartPhone3(private val m: Messenger2) : Messenger2 by m {
    override fun sendTextMessage() {
        println("Смартфон отправляет текстовое сообщение")
    }
}

// 5. Делегирование свойств
var counter: Int by Delegates.observable(initialValue = 0) { _, old, new ->
    println("Счётчик изменился: $old -> $new")
}

class User {
    var name: String by Delegates.observable(initialValue = "<no name>") { _, old, new ->
        println("Имя изменено: '$old' -> '$new'")
    }
}

fun main() {
    // 1
    val b = BaseImpl(10)
    Derived(b).print() // 10

    // 2
    val max = InstantMessenger()
    val yotaPhone = SmartPhone(max)
    yotaPhone.send("Привет!")

    // 3
    val camera = PhotoCamera()
    val phone = SmartPhone2(max, camera)
    phone.send("Фото?")
    phone.takePhoto()

    // 4
    val messenger2 = InstantMessenger2()
    val phone2 = SmartPhone3(messenger2)
    phone2.sendTextMessage()
    phone2.sendVoiceMessage()

    // 5
    counter = 1
    counter = 5

    val user = User()
    user.name = "Дота"
    user.name = "Пудж"
}