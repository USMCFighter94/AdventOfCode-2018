import java.io.File

fun main(args: Array<String>) {
    val inputFile = args.takeIf { it.isNotEmpty() }?.get(0)?.takeIf { it.isNotEmpty() } ?: "inputs.txt"
    val file = File(inputFile)
    val frequencyAdjustments = file.readLines()
    val frequenciesSeen = arrayListOf(0)

    var frequency = 0
    var foundDuplicate = false

    while (!foundDuplicate) {
        frequencyAdjustments.forEach {
            when (it[0]) {
                '+' -> {
                    frequency += it.substring(1, it.length).toInt()

                    if (frequenciesSeen.contains(frequency)) {
                        System.out.println("Found duplicate frequency $frequency")
                        foundDuplicate = true
                        return@forEach
                    }

                    frequenciesSeen.add(frequency)
                }
                '-' -> {
                    frequency -= it.substring(1, it.length).toInt()

                    if (frequenciesSeen.contains(frequency)) {
                        System.out.println("Found duplicate frequency $frequency")
                        foundDuplicate = true
                        return@forEach
                    }

                    frequenciesSeen.add(frequency)
                }
                else -> System.out.println("Invalid input $it")
            }
        }
    }

    System.out.println("Calibrated frequency is $frequency")
}