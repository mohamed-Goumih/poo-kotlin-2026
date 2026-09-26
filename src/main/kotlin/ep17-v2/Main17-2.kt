import ep17.Auteur
import ep17.Bibliothetique
import ep17.Livre

fun main() {
    val auteur1= Auteur("A1","B1")
    val auteur2= Auteur("B2","B2")
    val livre1= Livre("Livre1", "L4567",auteur1)
    val livre2= Livre("Livre2", "L124",auteur2)
    val livreModifie= Livre("LivreModifie", "L12444",auteur2)
    val biblio= Bibliothetique()
    biblio.ajouterLivres(livre1)
    biblio.ajouterLivres(livre2)
    biblio.ajouterAuteur(auteur1)
    biblio.ajouterAuteur(auteur2)

    biblio.rechercherLivreParAuteur("L1")
    biblio.rechercherLivreParAuteur("L2")
    biblio.mettreAjourLivre("L2",livreModifie)
    biblio.supprimerLivre("L1")
    biblio.afficherTousLesLivres()

}