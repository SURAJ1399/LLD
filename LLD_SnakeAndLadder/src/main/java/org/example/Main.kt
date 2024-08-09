package org.example

import org.example.data.Player
import java.util.LinkedList

fun main() {
    println("Hello")
    val p1 = Player(1, "p1", 0)
    val p2 = Player(2, "p2", 0)
    val p3 = Player(3, "p3", 0)
    val playerList = LinkedList<Player>()
    playerList.add(p1)
    playerList.add(p2)
    playerList.add(p3)
    Game(playerList, Board.createBoard(10, 5, 5)).start()


}


