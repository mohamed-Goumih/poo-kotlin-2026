package etape02

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 2 — Constructeur primaire, bloc init, constructeur secondaire
// ═══════════════════════════════════════════════════════════════

class Stagiaire(val nom: String, var note: Double = 0.0)
{   // constructeur PRIMAIRE
    var groupe: String = "non affecté"   // 1) initialiseurs de propriétés (dans l'ordre)

    init {                               // 2) bloc init (exécuté juste après, dans l'ordre)
        require(note in 0.0..20.0) { "Note invalide : $note" }
        println("[init] Création de $nom")
    }

    // Constructeur SECONDAIRE : doit déléguer au primaire avec this(...)
    constructor(nom: String, note: Double, groupe: String) : this(nom, note) {
        this.groupe = groupe             // 3) corps du secondaire, en DERNIER
        println("[secondaire] Groupe = $groupe")
    }

    fun presenter() = println("$nom ($groupe) — note : $note")
}

fun main() {
    val a = Stagiaire("Salma", 15.5)
    val b = Stagiaire("Yassine")                 // paramètre par défaut → note = 0.0
    val c = Stagiaire("Hiba", 17.0, "DEV101")    // secondaire → primaire → init → corps
    listOf(a, b, c).forEach { it.presenter() }

    // a.nom = "Autre"   // ❌ val : lecture seule
    a.note = 16.0        // ✅ var : modifiable

    //Stagiaire("Omar", 25.0)   // 💥 IllegalArgumentException levée par require dans init
}
