package behavioral


fun main() {
    val perimeterVisitor = PerimeterVisitor()
    val circle = Circle()
    circle.accept(perimeterVisitor)
    println(circle.peri)
    val rec = Rec()
    rec.accept(perimeterVisitor)
    println(rec.peri)

}

interface ShapeElement {
    fun accept(shapeVisitor: ShapeVisitor)
}

class Circle() : ShapeElement {
    var peri: Int = 0
    override fun accept(shapeVisitor: ShapeVisitor) {
        shapeVisitor.visit(this)
    }
}

class Square() : ShapeElement {
    var peri: Int = 0
    override fun accept(shapeVisitor: ShapeVisitor) {
        shapeVisitor.visit(this)
    }
}

class Rec() : ShapeElement {
    var peri: Int = 0
    override fun accept(shapeVisitor: ShapeVisitor) {
        shapeVisitor.visit(this)
    }
}

interface ShapeVisitor {
    fun visit(circle: Circle)
    fun visit(square: Square)
    fun visit(rec: Rec)
}


class PerimeterVisitor() : ShapeVisitor {
    override fun visit(circle: Circle) {
        circle.peri = 2
    }

    override fun visit(square: Square) {
        square.peri = 3
    }

    override fun visit(rec: Rec) {
        rec.peri = 4
    }


}
