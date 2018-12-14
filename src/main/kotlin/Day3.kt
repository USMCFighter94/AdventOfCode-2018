import kotlin.streams.asStream

class Day3(override val adventOfCode: AdventOfCode) : Day {
    override val day = 3

    data class Coordinate(val id: Int, val left: Int, val top: Int, val width: Int, val height: Int)

    private val numberRegex = Regex("-?\\d+")
    private val input = adventOfCode.getInput(2018, day).lines().map { line ->
        numberRegex.findAll(line).run {
            Coordinate(
                elementAt(0).value.toInt(),
                elementAt(1).value.toInt(),
                elementAt(2).value.toInt(),
                elementAt(3).value.toInt(),
                elementAt(4).value.toInt()
            )
        }
    }

    private val grid = List(1000) { IntArray(1000) }

    override fun part1(): String {
        input.forEach { coordinate ->
            for (i in coordinate.left until coordinate.left + coordinate.width) {
                for (j in coordinate.top until coordinate.top + coordinate.height) {
                    grid[i][j] += 1
                }
            }
        }

        return "${grid.stream().flatMap { it.asSequence().asStream() }.filter { it >= 2 }.count()}"
    }

    override fun part2(): String {
        input.forEach { coordinate ->
            var noOverlap = true
            outerLoop@for (i in coordinate.left until coordinate.left + coordinate.width) {
                for (j in coordinate.top until coordinate.top + coordinate.height) {
                    if (grid[i][j] > 1) {
                        noOverlap = false
                        continue@outerLoop
                    }
                }
            }
            if (noOverlap) {
                return "${coordinate.id}"
            }
        }

        return "Didn't find a Coordinate without overlap"
    }
}