package modules

import resources.ResourceManager
import resources.OutpostResource

class ResearchLab : OutpostModule(name = "Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager) {
        println("Лаборатория исследует... Требует 10 минералов")
        val minerals = manager.get("Minerals")
        if (minerals != null && minerals.amount >= 10) {
            minerals.amount -= 10
            println("Исследование прошло успешно. Осталось минералов: ${minerals.amount}")
        } else {
            println("Недостаточно минералов для исследования")
        }
    }
}