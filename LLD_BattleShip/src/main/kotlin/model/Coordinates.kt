package model

data class Coordinates(val x: Int, val y: Int)

data class Cell(
    val coordinates: Coordinates,
    val cellState: CellState = CellState.EMPTY
)

enum class CellState(val key: String) {
    DESTROYED("X"),
    MISSED("O"),
    BATTLESHIP("B"),
    MISSILE("M"),
    EMPTY("_"),
}
