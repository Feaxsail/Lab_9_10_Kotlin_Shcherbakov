package outpost

import modules.ModuleResult

abstract class OutpostModule {
    abstract fun performAction(): ModuleResult
}

class EnergyGenerator : OutpostModule() {
    override fun performAction(): ModuleResult {
        return ModuleResult.ResourceProduced("Энергия", 100)
    }
}

class ResearchLab : OutpostModule() {
    override fun performAction(): ModuleResult {
        return ModuleResult.Success("Исследование завершено")
    }
}