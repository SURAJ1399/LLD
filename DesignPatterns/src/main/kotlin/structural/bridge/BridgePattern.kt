package structural.bridge


/*** The Bridge design pattern allows you to separate the abstraction from the implementation. It is a structural design pattern.

There are 2 parts in Bridge design pattern :

Abstraction
Implementation ***/

abstract class Vehicle() {
    abstract fun refill()

}
//
//class Car() : Vehicle() {
//
//    override fun refill() {
//        println("care filled")
//    }
//}
//
//class ElectricCar() : Vehicle() {
//
//    override fun refill() {
//        println("electric care filled")
//    }
//}

//class XYZCar() : Vehicle() {
//
//    override fun refill() {
//        println("electric care filled")
//    }
//}
//
//class XYZBike() : Vehicle() {
//
//    override fun refill() {
//        println("electric care filled")
//    }
//}

//
//
//class PetrolCar() : Vehicle() {
//
//    override fun refill() {
//        println("petrol care filled")
//    }
//}
//
//
//class Bike() : Vehicle() {
//
//    override fun refill() {
//        println("bike filled")
//    }
//}
//
//
//class ElectricBike() : Vehicle() {
//
//    override fun refill() {
//        println("bike charged")
//    }
//}
//
//
//class PetrolBike() : Vehicle() {
//
//    override fun refill() {
//        println("petrol bike filled")
//    }
//}
//
//
//fun main() {
//    val car = Car()
//    car.refill()
//}

interface IEngineType {
    fun refill(){}
}

class PetrolEngineImplementor() : IEngineType{
    override fun refill() {
        println("petrol engine refilled")
    }
}

class ElectricEngineImplementor() : IEngineType{
    override fun refill() {
        println("charged")
    }
}

class XYZEngineImplementor() : IEngineType{
    override fun refill() {
        println("xyz refilled")
    }
}

class Car(private val engineImplementor: IEngineType) : Vehicle() {
    override fun refill() {
        engineImplementor.refill()
    }

}

class Bike(private val engineImplementor: IEngineType) : Vehicle() {
    override fun refill() {
        engineImplementor.refill()
    }

}

fun main() {
    val car =Car(PetrolEngineImplementor())
    car.refill()
    val bike =  Bike(PetrolEngineImplementor())
    bike.refill()
    val carxyz = Car(XYZEngineImplementor())
    val bikexyz = Bike(XYZEngineImplementor())


}