package etape03

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 3 — Héritage (open) et redéfinition (override)
// ═══════════════════════════════════════════════════════════════
// Par défaut, classes et méthodes Kotlin sont FINAL.
// open = "autorisé à hériter / à redéfinir".

open class Personne(val nom: String) {
    open fun role(): String = "personne"
    fun sePresenter() = println("Je suis $nom, ${role()}")   // final : non redéfinissable
}

class Stagiaire(nom: String, val groupe: String) : Personne(nom) {   // appel du constructeur parent
    override fun role() = "stagiaire du groupe $groupe"
}

class Formateur(nom: String, val specialite: String) : Personne(nom) {
    override fun role() = "formateur en $specialite"
}

fun main() {
    // Polymorphisme : une liste de Personne, chaque objet répond à SA façon
    val personnes: List<Personne> = listOf(
        Stagiaire("Salma", "DEV101"),
        Formateur("M. Alami", "Kotlin"),
        Personne("Visiteur")
    )
    personnes.forEach { it.sePresenter() }

    // Test de type + smart cast
    for (p in personnes) {
        if (p is Stagiaire) println("${p.nom} est dans ${p.groupe}")   // p casté automatiquement
    }
}
