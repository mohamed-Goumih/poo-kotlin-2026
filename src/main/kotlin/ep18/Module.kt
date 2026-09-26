package ep18

// --- Étape 186 & 189 : Classe Module ---
class Module(val nom: String) {
    val stagiairesInscrits: MutableList<Stagiaire> = mutableListOf()
    val notes: MutableList<Note> = mutableListOf()
    var formateur: Formateur? = null

    // Étape 186 : Gérer l'inscription des stagiaires
    fun inscrireStagiaire(stagiaire: Stagiaire) {
        if (!stagiairesInscrits.contains(stagiaire)) {
            stagiairesInscrits.add(stagiaire)
        }
    }

    // Étape 189 : Gérer les examens et ajouter des notes
    fun ajouterNoteExamen(stagiaire: Stagiaire, noteValeur: Double) {
        if (stagiairesInscrits.contains(stagiaire)) {
            val nouvelleNote = Note(noteValeur, this, stagiaire)
            notes.add(nouvelleNote)
            stagiaire.notes.add(nouvelleNote)
            println("Note de $noteValeur ajoutée pour ${stagiaire.prenom} dans le module $nom.")
        } else {
            println("Erreur : Le stagiaire ${stagiaire.prenom} n'est pas inscrit à ce module.")
        }
    }

    // Méthode pour affecter un formateur
    fun affecterFormateur(formateur: Formateur) {
        this.formateur = formateur
        if (!formateur.modulesEnseignes.contains(this)) {
            formateur.modulesEnseignes.add(this)
        }
    }
}
