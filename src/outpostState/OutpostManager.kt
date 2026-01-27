package outpostState

class OutpostManager {
    private val _resources = mutableListOf<ObservableResource>()
    val resources: List<ObservableResource>
        get() = _resources.toList()

    fun addResource(resource: ObservableResource) {
        _resources.add(resource)
    }
}