package etape07

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 7 — enum class : un ensemble FERMÉ de constantes
// ═══════════════════════════════════════════════════════════════

enum class Filiere(val libelle: String, val semestres: Int) {   // constantes avec propriétés
    DEV("Développement digital", 4),
    INFRA("Infrastructure digitale", 4),
    IA("Intelligence artificielle", 4);    // ⚠️ point-virgule obligatoire avant les membres

    fun description() = "$libelle ($semestres semestres)"
}

class Stagiaire(val nom: String, val filiere: Filiere)

fun conseil(f: Filiere) = when (f) {       // when EXHAUSTIF : pas besoin de else
    Filiere.DEV -> "Codez un peu chaque jour"
    Filiere.INFRA -> "Montez un lab réseau"
    Filiere.IA -> "Révisez les bases de maths"
}

fun main() {
    for (f in Filiere.entries) {           // entries (Kotlin ≥ 1.9) remplace values()
        println("${f.ordinal} : ${f.name} → ${f.description()}")
    }

    val s = Stagiaire("Hiba", Filiere.valueOf("IA"))
    println("${s.nom} : ${conseil(s.filiere)}")

    // valueOf est sensible à la casse :
    println(runCatching { Filiere.valueOf("dev") }.exceptionOrNull())   // IllegalArgumentException
}
