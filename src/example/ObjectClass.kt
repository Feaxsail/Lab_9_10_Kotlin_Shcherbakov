package example

object GameSession {
    init {
        println("GameSession создан")
    }

    fun start() {
        println("Игра запущена")
    }
}

fun main() {
    println("До обращения к GameSession")
    GameSession.start()
    println("После первого вызова")

    val session1 = GameSession
    val session2 = GameSession
    println("session1 === session2: ${session1 === session2}")
}