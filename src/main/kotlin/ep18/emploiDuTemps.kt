package ep18

import java.util.Date


// --- Étape 188 : Classe EmploiDuTemps ---
class EmploiDuTemps {
    // Map associant un module à une paire de dates (début, fin)
    val cours: MutableMap<Module, Pair<Date, Date>> = mutableMapOf()

    fun ajouterCours(module: Module, dateDebut: Date, dateFin: Date) {
        cours[module] = Pair(dateDebut, dateFin)
        println("Cours ajouté pour le module ${module.nom}.")
    }

    fun getCoursPourModule(module: Module): Pair<Date, Date>? {
        return cours[module]
    }

    fun getCoursPourDate(date: Date): List<Pair<Module, Pair<Date, Date>>> {
        return cours.filter { it.value.first <= date && it.value.second >= date }.map { it.key to it.value }
    }
}
