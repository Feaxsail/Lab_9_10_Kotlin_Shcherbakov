interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop(){
        println("Останавливаемся...")
    }
}

interface VideoPlayable{
    fun play() = println("Play video")
}

interface AudioPlayable{
    fun play() = println("Play audio")
}

class MediaPlayer: VideoPlayable, AudioPlayable{
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}



interface Worker{
    fun work()
}
interface Student{
    fun study()
}

class Car(override val model: String, override val number: String): Movable{
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км.ч")
    }
}

class Aircraft(override val model: String, override val number: String) : Movable{
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км.ч")
    }
    override fun stop() = println("Приземляемся...")
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun work() = println("$name работает")
    override fun study() = println("$name учится")


}

fun travel(obj: Movable) = obj.move()

fun main() {
    val car = Car(model = "LADA", number = "134LAD")
    val aircraft = Aircraft(model = "Boeing", number = "737")
    travel(obj = car)
    travel(obj = aircraft)
    car.move()
    aircraft.move()

    val pavel = WorkingStudent(name = "Pavel")
    pavel.work()
    pavel.study()

    aircraft.move()
    aircraft.stop()

    val player = MediaPlayer()
    player.play()
}