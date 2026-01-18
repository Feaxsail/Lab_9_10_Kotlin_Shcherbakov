package characters

class OutpostWorker(val name: String) {
    var maxEnergy = 100
    var energy: Int = 100
        set(value) {
            field = value.coerceIn(0, maxEnergy)
        }

    var mood: Int = 50
        get() = field + (energy / 10)

    var level: Int = 1
        private set

    fun work() {
        println("$name работает...")
        energy -= 15
        if (energy < 20) {
            println("Внимание: низкая энергия!")
        }
    }

    fun rest() {
        println("$name отдыхает...")
        energy += 20
    }

    fun levelUp() {
        level++
        maxEnergy += 20
        energy = maxEnergy
        println("$name повышает уровень: $level | Макс. энергия: $maxEnergy")
    }
}