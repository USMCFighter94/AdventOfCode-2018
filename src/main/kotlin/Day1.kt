class Day1(override val adventOfCode: AdventOfCode) : Day {
    override val day = 1
    private val input = adventOfCode.getInput(2018, day).lines().map { it.toLong() }.toLongArray()

    override fun part1() = "" + input.fold(0L) { a, n -> a + n }

    override fun part2(): String {
        val known = mutableSetOf<Long>()

        var curr = 0L
        var index = 0

        while (true) {
            if (!known.add(curr))
                break
            curr += input[index]
            index = (index + 1) % input.size
        }

        return "" + curr
    }
}