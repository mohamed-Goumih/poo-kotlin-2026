package etape06

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 6 — Classe imbriquée (nested) vs classe interne (inner)
// ═══════════════════════════════════════════════════════════════

class Groupe(val code: String) {
    private val stagiaires = mutableListOf<String>()
    fun inscrire(nom: String) { stagiaires += nom }

    // inner : liée à UNE instance de Groupe → accès à code et à stagiaires (même private)
    inner class Seance(val module: String, val salle: String) {
        fun appel() = println("$module en salle $salle — ${code} : ${stagiaires.joinToString()}")
    }

    // nested (sans inner) : indépendante, AUCUN accès aux membres de Groupe
    class Salle(val numero: String) {
        // fun test() = code   // ❌ Unresolved reference
    }
}

fun main() {
    val dev101 = Groupe("DEV101")
    dev101.inscrire("Salma"); dev101.inscrire("Yassine")

    val seance = dev101.Seance("M205 Kotlin", "B12")   // créée À PARTIR d'une instance
    seance.appel()

    val salle = Groupe.Salle("B12")                    // créée à partir de la CLASSE
    println("Salle ${salle.numero}")
}
