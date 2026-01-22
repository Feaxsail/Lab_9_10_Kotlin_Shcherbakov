package gameCharacter

class GameCharacter(val name: String) {
    var state: CharacterState = CharacterState.Idle  // По умолчанию бездействие

    fun changeState(newState: CharacterState) {
        state = newState
        println("Состояние персонажа '$name' изменено")
    }
}