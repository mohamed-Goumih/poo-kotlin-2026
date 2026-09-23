package etape10

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 10 — object (singleton) + SYNTHÈSE de toute la séance
// ═══════════════════════════════════════════════════════════════

enum class Filiere(val libelle: String) { DEV("Développement digital"), IA("Intelligence artificielle") }   // enum

interface Evaluable {                                                    // interface
    val notes: MutableList<Double>
    fun ajouterNote(n: Double) { notes += n }
    fun moyenne() = if (notes.isEmpty()) 0.0 else notes.average()
}

abstract class Personne(val nom: String) {                               // classe abstraite
    abstract val role: String
    open fun fiche() = "[$role] $nom"
}

class Stagiaire private constructor(                                     // héritage + interface
    val matricule: String, nom: String, val filiere: Filiere
) : Personne(nom), Evaluable {
    override val role = "Stagiaire"
    override val notes = mutableListOf<Double>()
    override fun fiche() = "${super.fiche()} ($matricule, ${filiere.libelle}) moy=%.2f".format(moyenne())

    companion object {                                                   // companion
        private var compteur = 0
        fun creer(nom: String, filiere: Filiere) =
            Stagiaire("CMC-${(++compteur).toString().padStart(4, '0')}", nom, filiere)
    }
}

class Formateur(nom: String, val specialite: String) : Personne(nom) {
    override val role = "Formateur"
    override fun fiche() = super.fiche() + " — $specialite"
}

sealed class Resultat {                                                  // sealed
    data class Ok(val stagiaire: Stagiaire) : Resultat()
    data class Erreur(val message: String) : Resultat()
}

// object : UNE seule instance dans toute l'application, créée au premier accès
object Registre {
    private val personnes = mutableListOf<Personne>()

    fun ajouter(p: Personne) { personnes += p }

    fun inscrire(nom: String, filiere: Filiere): Resultat =
        if (personnes.any { it.nom == nom }) Resultat.Erreur("$nom déjà inscrit(e)")
        else Resultat.Ok(Stagiaire.creer(nom, filiere).also { personnes += it })

    fun stagiaires() = personnes.filterIsInstance<Stagiaire>()
    fun afficherTout() = personnes.forEach { println(it.fiche()) }   // polymorphisme
}

fun main() {
    Registre.ajouter(Formateur("M. Alami", "Kotlin"))

    for (nom in listOf("Salma", "Yassine", "Salma")) {
        when (val r = Registre.inscrire(nom, Filiere.DEV)) {
            is Resultat.Ok -> println("✅ ${r.stagiaire.matricule} attribué à $nom")
            is Resultat.Erreur -> println("❌ ${r.message}")
        }
    }

    Registre.stagiaires()[0].apply { ajouterNote(15.0); ajouterNote(17.0) }
    Registre.stagiaires()[1].ajouterNote(11.5)

    println("\n--- Registre ---")
    Registre.afficherTout()

    val a = Registre; val b = Registre
    println("\nMême instance ? ${a === b}")   // true → singleton (cf. Challenge 15, Q3)
}
