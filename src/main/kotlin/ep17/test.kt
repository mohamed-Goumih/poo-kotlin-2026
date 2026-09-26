import java.util.Locale

// Exercice 1
fun convertirEnInts(ligne: String): List<Int> =
    ligne.trim()
        .split(Regex("\\s+"))
        .mapNotNull { it.toIntOrNull() }

fun main() {
    val ligne = readln() // Exemple : "12 5 7 12 9 5 5"
    val nombres = convertirEnInts(ligne)

    if (nombres.isNotEmpty()) {
        val min = nombres.minOrNull()!!
        val max = nombres.maxOrNull()!!
        val avg = String.format(Locale.US, "%.2f", nombres.average())
        println("min=$min max=$max avg=$avg distinct=${nombres.distinct().size}")
    }
}