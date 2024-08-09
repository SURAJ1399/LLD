import model.*
import util.GameConstants

class Mechanics {

    fun attack(player: Player, opponent: Player) {
        val missileList = player.missile
        val targetList = opponent.battleShip
        missileList.forEach { missileCoordinates ->
            targetList.find { targetCoordinates ->
                missileCoordinates == targetCoordinates
            }?.let {
                val updatedMissileList = player.missile.toMutableList()
                updatedMissileList.remove(missileCoordinates)
                player.missile = updatedMissileList

                val updatedShipList = opponent.battleShip.toMutableList()
                updatedShipList.remove(it)
                opponent.battleShip = updatedShipList

                handleShipDestroyed(opponent, it)
            }
        }
    }

    private fun handleShipDestroyed(player: Player, coordinates: Coordinates) {
        val mCell = Cell(coordinates, CellState.DESTROYED)
        player.cellList.add(mCell)
    }

    fun updateShipNotDestroyed(player1: Player, player2: Player) {
        player1.battleShip.forEach {
            player1.cellList.add(Cell(it, CellState.BATTLESHIP))
        }

        player2.battleShip.forEach {
            player2.cellList.add(Cell(it, CellState.BATTLESHIP))
        }

    }

    fun updateMissedMissile(player1: Player, player2: Player) {
        player2.missile.forEach {
            player1.cellList.add(Cell(it, CellState.MISSED))
        }

        player1.missile.forEach {
            player2.cellList.add(Cell(it, CellState.MISSED))
        }
    }

    fun printResult(player1: Player, player2: Player) {
        when (player1.missile.size - player2.missile.size) {
            0 -> print(GameConstants.DRAW_MSG)
            in 1..Int.MAX_VALUE -> print("PLAYER 1 $GameConstants.WIN_MSG")
            else -> print("PLAYER 2 $GameConstants.WIN_MSG")
        }
    }

}