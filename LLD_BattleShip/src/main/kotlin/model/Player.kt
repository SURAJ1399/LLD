package model

data class Player(
    val cellList: MutableList<Cell> = emptyList<Cell>().toMutableList(),
    var battleShip: List<Coordinates> = emptyList(),
    var missile: List<Coordinates> = emptyList(),
)