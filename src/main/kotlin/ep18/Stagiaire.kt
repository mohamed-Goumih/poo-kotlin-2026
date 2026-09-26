package ep18

// --- Étape 182 & 185 & 1810 : Classe Stagiaire ---
class Stagiaire(
    override val nom: String,
    override val prenom: String,
    val numeroDeStagiaire: String
) : Person(nom, prenom)
{

    // Étape 183 : Liste des modules inscrits
    val modulesInscrits: MutableList<Module> = mutableListOf()

    // Liste des notes obtenues
    val notes: MutableList<Note> = mutableListOf()

    // Étape 1810 : Évaluations des formateurs
    val evaluationsFormateurs: MutableMap<Formateur, Int> = mutableMapOf()

    // Étape 183 : S'inscrire à un module
    fun sInscrireAuModule(module: Module) {
        if (!modulesInscrits.contains(module)) {
            modulesInscrits.add(module)
            module.inscrireStagiaire(this) // Lien bidirectionnel
        } else {
            println("Le stagiaire $this est déjà inscrit au module ${module.nom}.")
        }
    }

    // Étape 185 : Calculer la moyenne
    fun calculerMoyenne(): Double {
        if (notes.isEmpty()) return 0.0
        return notes.map { it.valeur }.average()
    }

    // Étape 1810 : Évaluer un formateur
    fun evaluerFormateur(formateur: Formateur, noteEvaluation: Int) {
        if (noteEvaluation in 1..5) { // Supposons une échelle de 1 à 5
            evaluationsFormateurs[formateur] = noteEvaluation
            println("Le formateur $formateur a été évalué avec la note de $noteEvaluation par $this.")
        } else {
            println("La note d'évaluation doit être comprise entre 1 et 5.")
        }
    }
}