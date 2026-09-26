package ep18


// --- Classe SystemeFormation (d'après l'UML) ---
class SystemeFormation : Evaluations {
    val stagiaires: MutableList<Stagiaire> = mutableListOf()
    val formateurs: MutableList<Formateur> = mutableListOf()
    val modules: MutableList<Module> = mutableListOf()
    val emploiDuTemps: EmploiDuTemps = EmploiDuTemps()

    fun ajouterStagiaire(stagiaire: Stagiaire) {
        stagiaires.add(stagiaire)
    }

    fun ajouterFormateur(formateur: Formateur) {
        formateurs.add(formateur)
    }

    fun ajouterModule(module: Module) {
        modules.add(module)
    }

    // Implémentation de l'interface Evaluations
    override fun ajouterNote(stagiaire: Stagiaire, module: Module, note: Double) {
        module.ajouterNoteExamen(stagiaire, note)
    }

    override fun calculerMoyenne(stagiaire: Stagiaire): Double {
        return stagiaire.calculerMoyenne()
    }

    // Étape 1811 : Persistance des données (Simulation)
    fun sauvegarderDonnees() {
        // Dans un vrai projet, on utiliserait une base de données ou une sérialisation JSON (ex: kotlinx.serialization)
        println("Sauvegarde des données du système de formation...")
    }

    fun chargerDonnees() {
        println("Chargement des données du système de formation...")
    }
}