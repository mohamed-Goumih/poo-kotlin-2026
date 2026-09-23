package etape08

// ═══════════════════════════════════════════════════════════════
// ÉTAPE 8 — sealed class : une hiérarchie FERMÉE de types
// ═══════════════════════════════════════════════════════════════
// enum  = nombre fixe d'INSTANCES (toutes de même forme)
// sealed = nombre fixe de SOUS-TYPES (chacun avec ses propres données)

sealed class Inscription {
    data class Acceptee(val nom: String, val groupe: String) : Inscription()
    data class Refusee(val nom: String, val motif: String) : Inscription()
    object EnAttente : Inscription()      // un seul cas, sans données → object
}

fun inscrire(nom: String, moyenne: Double, placesLibres: Int): Inscription = when {
    moyenne < 10 -> Inscription.Refusee(nom, "moyenne insuffisante")
    placesLibres == 0 -> Inscription.EnAttente
    else -> Inscription.Acceptee(nom, "DEV101")
}

fun message(r: Inscription): String = when (r) {    // exhaustif → pas de else
    is Inscription.Acceptee -> "✅ ${r.nom} inscrit(e) en ${r.groupe}"   // smart cast
    is Inscription.Refusee -> "❌ ${r.nom} : ${r.motif}"
    Inscription.EnAttente -> "⏳ Liste d'attente"
}

fun main() {
    println(message(inscrire("Salma", 15.0, 3)))
    println(message(inscrire("Omar", 8.5, 3)))
    println(message(inscrire("Hiba", 16.0, 0)))
    // 🔎 Ajoutez un cas "Annulee" à la sealed class : que dit le compilateur dans message() ?
}
