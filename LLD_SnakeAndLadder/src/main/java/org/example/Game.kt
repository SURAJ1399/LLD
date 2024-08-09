package org.example

import org.example.data.Player
import java.util.*


interface IWinStartegy {
    fun findWinnner()
}

class Game constructor(private val playerList: LinkedList<Player>, private val board: Board) :IWinStartegy {

    fun start() {
        var nextPlayer = 0
        val playerListSize = playerList.size
        while (true) {
            val dice = (1..6).random()
            val newPosition = playerList[nextPlayer].position + dice
            if (newPosition <= board.getBoardSize())
                playerList[nextPlayer].position += dice

            if (newPosition == board.getBoardSize()) {
                val playerName = playerList[nextPlayer].name
                println("WINS $playerName")
                break
            }
            nextPlayer = (nextPlayer + 1) % playerListSize
        }
    }

    override fun findWinnner() {
        TODO("Not yet implemented")
    }
}