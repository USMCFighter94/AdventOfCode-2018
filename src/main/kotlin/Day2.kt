class Day2(override val adventOfCode: AdventOfCode) : Day {
    override val day = 2
    private val input = adventOfCode.getInput(2018, day).lines()

    override fun part1(): String {
        val lineCounts = input.map { line -> line.groupingBy { it }.eachCount().values }
        return "" + lineCounts.count { 2 in it } * lineCounts.count { 3 in it }
    }

    override fun part2(): String {
        var commonLetters: String? = null

        for ((i, line) in input.withIndex()) {
            for (j in i + 1..input.lastIndex) {
                line.zip(input[j]) { a, b -> a.takeIf { it == b } }
                    .takeIf { it.count { it == null } == 1 }
                    ?.filterNotNull()
                    ?.joinToString(separator = "")
                    ?.let { commonLetters = it }
            }
        }

        return commonLetters ?: ""
    }
}