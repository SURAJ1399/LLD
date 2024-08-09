package structural.decorator

abstract class BasePizza {

    abstract fun getCost(): Int
}

class FarmHousePizza : BasePizza() {
    override fun getCost(): Int {
        return 120
    }

}

class VeggieDelightPizza : BasePizza() {
    override fun getCost(): Int {
        return 100
    }
}


abstract class ToppingDecorator : BasePizza() {
    override fun getCost(): Int {
        TODO("Not yet implemented")
    }
}

class MushroomTop constructor(private val basePizza: BasePizza) : ToppingDecorator() {
    override fun getCost(): Int {
        return basePizza.getCost() + 50
    }

}

class CheeseTop constructor(private val basePizza: BasePizza) : ToppingDecorator() {
    override fun getCost(): Int {
        return basePizza.getCost() + 80
    }

}

fun main() {
    val pizza = MushroomTop(FarmHousePizza()).getCost()
    val pizza2 = MushroomTop(CheeseTop(FarmHousePizza())).getCost()
}