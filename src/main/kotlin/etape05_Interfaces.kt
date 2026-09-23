package etape05

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 5 — Interfaces (contrat) + héritage multiple d'interfaces
// ═══════════════════════════════════════════════════════════════
// Une classe hérite d'UNE seule classe, mais implémente PLUSIEURS interfaces.
// Une interface ne stocke pas d'état : la propriété "notes" est fournie par la classe.

interface Evaluable {
    val notes: MutableList<Double>                            // abstraite
    fun ajouterNote(n: Double) { notes += n }                 // implémentation par défaut
    fun moyenne(): Double = if (notes.isEmpty()) 0.0 else notes.average()
    fun afficher() = println("moyenne = %.2f".format(moyenne()))
}

interface Affichable {
    fun afficher() = println("(affichage générique)")
}

abstract class Personne(val nom: String) {
    abstract val role: String
}

class Stagiaire(nom: String) : Personne(nom), Evaluable, Affichable {   // 1 classe + 2 interfaces
    override val role = "Stagiaire"
    override val notes = mutableListOf<Double>()

    // Conflit : afficher() existe dans Evaluable ET Affichable → override OBLIGATOIRE
    override fun afficher() {
        print("$nom → ")
        super<Evaluable>.afficher()      // on choisit explicitement la version voulue
    }
}

class Formateur(nom: String) : Personne(nom), Affichable {
    override val role = "Formateur"
}

// Programmer "vers l'interface" : cette fonction accepte tout ce qui est Evaluable
fun bulletin(e: Evaluable) = if (e.moyenne() >= 10) "Admis" else "Ajourné"

fun main() {
    val s = Stagiaire("Salma")
    s.ajouterNote(14.0);
    s.ajouterNote(17.5);
    s.ajouterNote(12.0)
    s.afficher()
    println(bulletin(s))

    Formateur("M. Alami").afficher()   // version par défaut d'Affichable
    // bulletin(Formateur("M. Alami"))  // ❌ Formateur n'est pas Evaluable
}
