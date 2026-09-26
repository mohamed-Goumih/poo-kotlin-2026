package ep18

// --- Étape 182 : Classe Formateur ---
class Formateur(
    override val nom: String,
    override val prenom: String,
    val specialite: String
) : Person(nom, prenom) {
    // Un formateur peut être associé à des modules
    val modulesEnseignes: MutableList<Module> = mutableListOf()
}
