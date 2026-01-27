package outpostState

class ResourceObserver {
    fun onResourceChanged(resource: ObservableResource, old: Int, new: Int) {
        println("[Наблюдатель] Ресурс '${resource.name}' изменился: $old → $new")
    }
}