fun main(){
    val manager = ResourceManager()
    val gas = OutpostResource(id = 1, name = "Gas", amount = 100)
    val mineral = OutpostResource(id = 2, name = "Mineral", amount = 250)
    manager.add(gas)
    manager.add(mineral)
    manager.printAll()
}