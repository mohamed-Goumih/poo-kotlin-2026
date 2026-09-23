package etape09

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 9 — companion object : membres liés à la CLASSE (≈ static Java)
// ═══════════════════════════════════════════════════════════════

class Stagiaire private constructor(val matricule: String, val nom: String) {   // constructeur privé !

    companion object {
        const val PREFIXE = "CMC-AGA"       // constante de compilation
        private var compteur = 0            // partagé par TOUTES les instances
        val total: Int get() = compteur

        // Fabrique (factory) : seul moyen de créer un Stagiaire
        fun creer(nom: String): Stagiaire {
            compteur++
            return Stagiaire("$PREFIXE-${compteur.toString().padStart(4, '0')}", nom)
        }
    }

    override fun toString() = "$matricule : $nom"
}

fun main() {
    // val s = Stagiaire("X", "Y")   // ❌ constructeur privé
    val a = Stagiaire.creer("Salma")      // appel sur le NOM de la classe
    val b = Stagiaire.creer("Yassine")
    println(a); println(b)
    println("Préfixe : ${Stagiaire.PREFIXE} — total créés : ${Stagiaire.total}")

    // Nuance vs Java : le companion est un VRAI objet (il peut implémenter une interface).
    // Pour l'appeler comme un static depuis du Java : annoter avec @JvmStatic.
}
