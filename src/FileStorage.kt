// FileStorage.kt

import java.io.File
import kotlin.properties.Delegates

object FileStorage {
    private const val FILE_NAME = "outpost_state.txt"

    fun save(resources: List<OutpostResource>) {
        val file = File(FILE_NAME)
        val text = resources.joinToString(separator = "\n") {
            "${it.id.toString().padEnd(3)} | ${it.name.padEnd(10)} | ${it.amount}"
        }
        file.writeText(text)
        println("Состояние базы сохранено в файл")
    }

    fun load(): List<OutpostResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            return emptyList()
        }
        return file.readLines().map { line ->
            val parts = line.split("|").map { it.trim() }
            OutpostResource(
                id = parts[0].toInt(),
                name = parts[1],
                amountInit = parts[2].toInt()
            )
        }
    }
}