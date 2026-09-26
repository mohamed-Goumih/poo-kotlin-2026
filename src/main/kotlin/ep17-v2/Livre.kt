package `ep17-v2`

class Livre (id: String, private val titre :String,
             private val isbn:String,
            private var auteur: Auteur): ItemDeBiliothetique(id), Imprimable
{

    //getters & setters
    override fun afficherInfo() {
       println("$titre $isbn ${auteur.getNom()} ${auteur.getPrenom()}")
    }

}
