import java.io.File

fun main(args: Array<String>) {
    val inputFile = args.takeIf { it.isNotEmpty() }?.get(0)?.takeIf { it.isNotEmpty() } ?: "inputs.txt"
    val file = File(inputFile)
    val boxIds = file.readLines()

    var commonLetters: String? = null

    for ((i, line) in boxIds.withIndex()) {
        for (j in i + 1..boxIds.lastIndex) {
            line.zip(boxIds[j]) { a, b -> a.takeIf { it == b } }
                .takeIf { it.count { it == null } == 1 }
                ?.filterNotNull()
                ?.joinToString(separator = "")
                ?.let { commonLetters = it }
        }
    }

    println("The common letters are: $commonLetters")
}