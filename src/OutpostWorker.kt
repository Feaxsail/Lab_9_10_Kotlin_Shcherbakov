class OutpostWorker(val name: String) {
    var maxEnergy: Int = 100
        private set

    var energy: Int = maxEnergy
        set(value) {
            field = value.coerceIn(0,maxEnergy)
        }
    var mood: Int = 50
        get() = field + (energy / 10)

    var level: Int = 1
        private set
    fun work(){
        println("$name выполняет работу...")
        energy -= 15
        if (energy < 20) println("$name устал!")
    }
    fun rest(){
        println("$name отдыхает...!")
        energy += 10
    }
    fun levelUp(){
        level++
        maxEnergy += 20
        energy = maxEnergy
        println("$name повысил уровень до $level")
    }

}

fun main(){
    val worker = OutpostWorker(name = "Зорин")
    println("Энергия: ${worker.energy}")
    println("Настроения: ${worker.energy}")
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    println("Энергия: ${worker.energy}")
    println("Настроения: ${worker.mood}")
    worker.rest()
//    worker.level = 15
    worker.energy = 200
    worker.levelUp()
}