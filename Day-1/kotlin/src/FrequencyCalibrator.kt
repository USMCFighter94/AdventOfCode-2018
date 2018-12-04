import java.io.File

fun main(args: Array<String>) {
    var total = 0
    val inputFile = args.takeIf { it.isNotEmpty() }?.get(0)?.takeIf { it.isNotEmpty() } ?: "inputs.txt"

    File(inputFile).forEachLine {
        when (it[0]) {
            '+' -> total += it.substring(1, it.length).toInt()
            '-' -> total -= it.substring(1, it.length).toInt()
            else -> System.out.println("Invalid input $it")
        }
    }

    System.out.println("Calibrated frequency is $total")
}