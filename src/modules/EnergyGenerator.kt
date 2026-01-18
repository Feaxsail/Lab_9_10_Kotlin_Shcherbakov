package modules

import resources.ResourceManager
import resources.OutpostResource

class EnergyGenerator : OutpostModule(name = "Генератор энергии") {
    override fun performAction(manager: ResourceManager) {
        println("Генератор работает... Производит 20 энергии")
        val energy = manager.get("Energy")
        if (energy != null) {
            energy.amount += 20
        } else {
            manager.add(OutpostResource(id = 99, name = "Energy", amount = 20))
        }
    }
}