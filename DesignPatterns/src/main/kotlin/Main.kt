import java.lang.Math.max
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {


    val theMap = HashMap<String, Int>()

    print(theMap["5"])

    data class Ans(var ans:String,
                   var dp:HashMap<String,String>)
    val ans = Ans("" , HashMap())
    val x= ans.dp["fhh"]
    val xd= kotlin.math.max(kotlin.math.max("6565", "57575"), "%7557")

}


typealias I = Int
typealias pair = Pair<Int, Int>

object Solution {

    fun isSafe(x: I, y: I, r: I, c: I, grid: Array<IntArray>): Boolean {
        if (x >= 0 && y >= 0 && x < r && y < c && grid[x][y] == 1) {
            return true
        }
        return false
    }

    val row = arrayOf(1, -1, 0, 0)
    val col = arrayOf(0, 0, -1, -1)

    fun orangesRotting(grid: Array<IntArray>): Int {

        val q = LinkedList<pair>()
        val r = grid.size
        q.removeFirst()
        val c = grid[0].size
        var ans = 0
        for (i in 0 until r) {
            for (j in 0 until c) {

                if (grid[i][j] == 2) {
                    q.push(Pair(i, j))
                    grid[i][j] = -1
                }
            }
        }
        while (!q.isEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                for (k in 0..3) {
                    val nr = q.first.first + row[k]
                    val nc = q.first.second + col[k]
                    if (isSafe(nr, nc, r, c, grid)) {
                        q.push(pair(nr, nc))
                        grid[nr][nc] = -1
                        q.removeFirst()
                    }

                }
            }
            ans++
        }

        for (i in 0 until r) {
            for (j in 0 until c) {

                if (grid[i][j] == 1) {
                    return -1
                }
            }
        }
        return ans
    }
}