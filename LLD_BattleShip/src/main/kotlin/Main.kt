import model.*


fun main() {
    val n = 5
    val player1 = Player()
    val player2 = Player()
    defineInput(player1, player2)
    val mechanics = Mechanics()
    mechanics.attack(player1, player2)
    mechanics.attack(player2, player1)
    mechanics.updateShipNotDestroyed(player1, player2)
    mechanics.updateMissedMissile(player1, player2)
    printOutPut(player1, player2, n)
    mechanics.printResult(player1, player2)
}


private fun defineInput(player1: Player, player2: Player) {
    defineBattleShip(player1, player2)
    defineMissiles(player1, player2)
}

private fun printOutPut(player1: Player, player2: Player, n: Int) {
    for (i in 0 until n) {
        for (j in 0 until n) {
            val cellState = player1.cellList.find { it.coordinates == Coordinates(i, j) }?.cellState ?: CellState.EMPTY
            print(cellState.key + " ")
        }
        println()
    }

    println()

    for (i in 0 until n) {
        for (j in 0 until n) {
            val cellState = player2.cellList.find { it.coordinates == Coordinates(i, j) }?.cellState ?: CellState.EMPTY
            print(cellState.key + " ")
        }
        println()
    }

    println()
}


private fun defineBattleShip(player1: Player, player2: Player) {
    player1.battleShip = mutableListOf(
        Coordinates(1, 1),
        Coordinates(2, 0),
        Coordinates(2, 3),
        Coordinates(3, 4),
        Coordinates(4, 3),
    )

    player2.battleShip = mutableListOf(
        Coordinates(0, 1),
        Coordinates(2, 3),
        Coordinates(3, 0),
        Coordinates(3, 4),
        Coordinates(4, 1),
    )
}


private fun defineMissiles(player1: Player, player2: Player) {
    player1.missile = mutableListOf(
        Coordinates(0, 1),
        Coordinates(4, 3),
        Coordinates(2, 3),
        Coordinates(3, 1),
        Coordinates(4, 1),
    )

    player2.missile = mutableListOf(
        Coordinates(0, 1),
        Coordinates(0, 0),
        Coordinates(1, 1),
        Coordinates(2, 3),
        Coordinates(4, 3),
    )
}