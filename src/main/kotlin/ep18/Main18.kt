import ep18.Formateur
import ep18.Module
import ep18.Stagiaire
import ep18.SystemeFormation
import java.util.Date


// --- Exemple d'utilisation (Main) ---
fun main() {
    val systeme = SystemeFormation()

    // Création des entités
    val stagiaire1 = Stagiaire("Dupont", "Jean", "STG001")
    val formateur1 = Formateur("Martin", "Sophie", "Informatique")
    val moduleKotlin = Module("Développement Kotlin")

    // Ajout au système
    systeme.ajouterStagiaire(stagiaire1)
    systeme.ajouterFormateur(formateur1)
    systeme.ajouterModule(moduleKotlin)

    // Inscriptions
    stagiaire1.sInscrireAuModule(moduleKotlin)
    moduleKotlin.affecterFormateur(formateur1)

    // Emploi du temps
    val dateDebut = Date()
    val dateFin = Date(System.currentTimeMillis() + 3600000) // +1 heure
    systeme.emploiDuTemps.ajouterCours(moduleKotlin, dateDebut, dateFin)

    // Évaluations (Notes)
    systeme.ajouterNote(stagiaire1, moduleKotlin, 15.5)
    systeme.ajouterNote(stagiaire1, moduleKotlin, 18.0)

    // Calcul de la moyenne
    val moyenne = systeme.calculerMoyenne(stagiaire1)
    println("Moyenne de ${stagiaire1.prenom} : $moyenne")

    // Évaluation d'un formateur par le stagiaire (Étape 1810)
    stagiaire1.evaluerFormateur(formateur1, 5)

    // Persistance (Étape 1811)
    systeme.sauvegarderDonnees()
}