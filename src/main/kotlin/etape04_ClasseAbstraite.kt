package etape04

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 4 — Classe abstraite
// ═══════════════════════════════════════════════════════════════
// "Personne" seule n'a pas de sens métier → on l'empêche d'être instanciée.

abstract class Personne(val nom: String) {
    abstract val role: String                 // PROPRIÉTÉ abstraite (pas de valeur)
    abstract fun heuresParSemaine(): Int      // MÉTHODE abstraite (pas de corps)

    open fun badge() = "[$role] $nom"         // concrète ET redéfinissable
    fun sePresenter() = println("${badge()} — ${heuresParSemaine()} h/semaine")   // concrète, finale
}

class Stagiaire(nom: String, val groupe: String) : Personne(nom) {
    override val role = "Stagiaire"
    override fun heuresParSemaine() = 35
}

class Formateur(nom: String, val specialite: String) : Personne(nom) {
    override val role = "Formateur"
    override fun heuresParSemaine() = 26
    override fun badge() = super.badge() + " ($specialite)"   // réutilise la version parente
}

fun main() {
    // val p = Personne("X")   // ❌ Cannot create an instance of an abstract class
    val equipe: List<Personne>
    = listOf(Stagiaire("Salma", "DEV101"),
        Formateur("M. Alami", "Kotlin"))
    equipe.forEach { it.sePresenter() }
}
