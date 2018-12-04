import java.io.File

fun main(args: Array<String>) {
    val inputFile = args.takeIf { it.isNotEmpty() }?.get(0)?.takeIf { it.isNotEmpty() } ?: "inputs.txt"
    val file = File(inputFile)
    val boxIds = file.readLines()

    val lineCounts = boxIds.map { line ->
        line.groupingBy { it }.eachCount().values
    }

    val checksum = lineCounts.count { 2 in it } * lineCounts.count { 3 in it }
    System.out.println("Checksum of inventory is $checksum")
}