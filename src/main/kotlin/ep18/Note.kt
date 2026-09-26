package ep18

import java.util.Date

// --- Étape 187 : Classe Note ---
data class Note(
    val valeur: Double,
    val module: Module,
    val stagiaire: Stagiaire,
    val date: Date = Date()
)