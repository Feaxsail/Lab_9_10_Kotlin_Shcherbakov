import modules.EnergyGenerator
import modules.ResearchLab
import resources.ResourceManager
import resources.OutpostResource

fun main() {
    val manager = ResourceManager()

    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 40))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    generator.performAction(manager)
    lab.performAction(manager)

    println()
    manager.printAll()
}