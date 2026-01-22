package gameCharacter

fun main() {

    val hero = GameCharacter("Pudge")


    fun handleCharacterState(state: CharacterState) {
        when (state) {
            is CharacterState.Idle -> println("Персонаж бездействует")
            is CharacterState.Running -> println("Персонаж бежит")
            is CharacterState.Attack -> println("Персонаж атакует с уроном ${state.damage}")
            is CharacterState.Dead -> println("Персонаж погиб: ${state.reason}")
        }
    }


    println("=== Начало игры ===")

    //  Бездействие
    handleCharacterState(hero.state)  // Вместо println("Текущее состояние: ${hero.state}")

    //  бег
    hero.changeState(CharacterState.Running)
    handleCharacterState(hero.state)

    //  атака
    hero.changeState(CharacterState.Attack(25))
    handleCharacterState(hero.state)

    // смерть
    hero.changeState(CharacterState.Dead("попадание стрелы в сердце"))
    handleCharacterState(hero.state)

    println("=== Конец игры ===")
}