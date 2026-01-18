Лабораторная работа №9-10: Продвинутое ООП на Kotlin

## Описание

Лабораторная работа посвящена изучению продвинутых концепций объектно-ориентированного
программирования в Kotlin.

## Изученные концепции

В ходе лабораторной работы были изучены следующие продвинутые концепции ООП в Kotlin:

### 1. Геттеры и сеттеры
Кастомные геттеры и сеттеры для контроля доступа к свойствам объектов.

**Пример из класса `OutpostWorker`:**
```kotlin
var energy: Int = 100
    set(value) {
        field = value.coerceIn(0, maxEnergy)
    }
```
### 2. Инкапсуляция
Изучен принцип инкапсуляции - скрытие внутреннего состояния объекта и управление доступом к нему.

Реализация через:

Модификаторы доступа (private, protected, internal, public)

Приватные сеттеры (private set)

Кастомные геттеры и сеттеры

Пример:
```kotlin
var level: Int = 1
    private set  // Запрет изменения уровня извне класса
```
### 3. Data-классы
Изучены data-классы - специальный тип классов в Kotlin для хранения данных с автоматической генерацией стандартных методов.
Пример OutpostResource:
```kotlin
data class OutpostResource(
    val id: Int,
    val name: String,
    var amount: Int
) {
    override fun toString(): String {
        return "Ресурс: $name (ID: $id) - Количество: $amount"
    }
}
```
### 4. Абстрактные классы
Изучены абстрактные классы - базовые классы, от которых нельзя создать объект напрямую.

Пример OutpostModule:
```kotlin
abstract class OutpostModule(
    val name: String,
    var level: Int = 1
) {
    fun upgrade() {
        level++
        println("Модуль $name повышен до уровня $level")
    }
    
    abstract fun performAction(manager: ResourceManager)
}
```
### 5. Интерфейсы
Изучены интерфейсы - контракты поведения, которые классы обязуются реализовать.
Пример интерфейса ModuleAction:
```kotlin
interface ModuleAction {
    fun execute(manager: ResourceManager)
}
```
Пример реализации интерфейсов
```kotlin
// Интерфейс
interface Movable {
    fun move()
    fun stop() {
        println("Остановка...")
    }
}

// Реализация в классе
class Car : Movable {
    override fun move() {
        println("Машина едет")
    }
}

// Полиморфизм
fun travel(vehicle: Movable) {
    vehicle.move()
    vehicle.stop()
}

// Использование
val car: Movable = Car()
travel(car)
```
### Проект "Galaxy Outpost Manager"
Описание проекта
Ты — управляющий космической базы. У тебя есть:

Рабочие (Workers)

Ресурсы (Resource)

Здания (OutpostModule)

Проект постепенно усиливается:

свойства с геттерами/сеттерами

data-классы для ресурсов

абстрактные классы для модулей

интерфейсы для действий

Структура проекта
```kotlin
src/
├── Main.kt                          # Главная точка входа программы
├── actions/                         # Интерфейсы
│   └── ModuleAction.kt
├── characters/                      # Персонажи
│   ├── Hero.kt
│   └── OutpostWorker.kt
├── example/                         # Примеры кода
│   ├── Interface.kt
│   └── Test.kt
├── modules/                         # Модули базы
│   ├── OutpostModule.kt
│   ├── EnergyGenerator.kt
│   └── ResearchLab.kt
└── resources/                       # Ресурсы
    ├── OutpostResource.kt
    └── ResourceManager.kt
```

# Как запустить проект
Клонируйте репозиторий:
```bash
git clone <URL_репозитория>
```
###  Откройте проект в IntelliJ IDEA.
###  Запустите любой пример через контекстное меню или напрямую из `main`.
## Автор
[Щербаков Данил Николаевич]
## Лицензия
Проект создан в учебных целях.