package ep18
// --- Étape 181 : Classe abstraite Person ---
 abstract class Person(open val nom: String, open val prenom: String) {
    override fun toString(): String {
        return "$prenom $nom"
    }

}