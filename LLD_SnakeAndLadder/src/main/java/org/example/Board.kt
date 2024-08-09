package org.example

import org.example.data.Ladder
import org.example.data.Snake
import java.util.UUID
import kotlin.random.Random

class Board(
    private val size: Int,
    private val snakesCount: Int,
    private val laddersCount: Int
) {

    private val snakes: ArrayList<Snake> = arrayListOf()
    private val ladders: ArrayList<Ladder> = arrayListOf()
    private val boardSquareCount = size * size

    init {
        defineSnakes()
        defineLadders()
    }

    companion object {
        fun createBoard(
            size: Int,
            snakes: Int,
            ladders: Int
        ): Board {
            return Board(size, snakes, ladders)
        }
    }

    fun getBoardSize(): Int {
        return boardSquareCount
    }

    private fun defineSnakes() {
        var mouthPosition = (1..boardSquareCount).random()
        var mouthRow = mouthPosition % size
        while (true) {
            val isSnakePresent = snakes.find { snake: Snake -> snake.mouth == mouthPosition }
            if (isSnakePresent != null || mouthRow == 1) {
                mouthPosition = (1..boardSquareCount).random()
                mouthRow = mouthPosition % size
            } else break
        }
        val tailStartRow = mouthRow - 1
        val tail = (1..tailStartRow * size).random()
        snakes.add(Snake(mouthPosition, tail))

    }


    private fun defineLadders() {
        var bottom = (1..boardSquareCount).random()
        var bottomRow = bottom % size
        while (true) {
            val isLadderPresent = ladders.find { ladder: Ladder -> ladder.bottom == bottom }
            val isSnakePresent = snakes.find { snake: Snake -> snake.mouth == bottom }
            if (isLadderPresent != null || isSnakePresent != null) {
                bottom = (1..boardSquareCount).random()
                bottomRow = bottom % size
            } else break
        }
        val topRow = bottomRow + 1
        val top = (topRow * size..boardSquareCount).random()
        ladders.add(Ladder(bottom, top))
    }

}