package ep18

import java.util.Date

// --- Étape 184 : Interface Evaluations ---
interface Evaluations {
    fun ajouterNote(stagiaire: Stagiaire, module: Module, note: Double)
    fun calculerMoyenne(stagiaire: Stagiaire): Double
}


