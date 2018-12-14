import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please specify session id!")
        return
    }

    val adventOfCode = AdventOfCode(args[0])
    val list = listOf(
        Day1(adventOfCode),
        Day2(adventOfCode),
        Day3(adventOfCode)
    )

    list.forEach { day ->
        StringBuilder().apply {
            appendln("---------------- Day ${day.day.toString().padStart(2, '0')} ----------------")
            val first = measureTimeMillis { appendln("Part 1: ${day.part1()}") }
            val second = measureTimeMillis { appendln("Part 2: ${day.part2()}") }
            appendln("Part 1 took ${first}ms, Part 2 took ${second}ms")
            print(toString())
        }
    }
}