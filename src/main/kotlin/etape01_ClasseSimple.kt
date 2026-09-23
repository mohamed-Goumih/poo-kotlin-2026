package etape01

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 1 — Une classe, des propriétés, une méthode, une instance
// ═══════════════════════════════════════════════════════════════

class Stagiaire
{
    var nom: String = ""       // propriété (avec getter/setter générés)
    var note: Double = 0.0

    fun presenter() {          // méthode
        println("Je suis $nom, ma note est $note")
    }
}
class Stagiaire2(var nom:String="",var note: Double=0.0){
    fun presenter() = println("Je suis $nom, ma note est $note")
}
class Stagiaire3{
    var nom: String?
    var note: Double?
    constructor(nom:String="ali",note:Double=0.0){
        this.nom = nom
        this.note = note
    }
}

fun main() {
    val s3= Stagiaire3()
    val s1=Stagiaire2("salma",34.0)
    println(s1.nom)
    println(s1.note)
    s1.presenter()
    val s = Stagiaire()        // pas de mot-clé "new" en Kotlin
    s.nom = "Salma"            // appelle le setter généré
    s.note = 15.5
    s.nom="Ali"
    s.note=17.0
    s.presenter()

    // 🔎 Question aux stagiaires : "val s" alors qu'on modifie s.nom… pourquoi ça compile ?
    // → val protège la RÉFÉRENCE s, pas l'état interne de l'objet.
}
