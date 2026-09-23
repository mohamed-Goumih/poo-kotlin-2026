package ep17

class Auteur(nom:String,prenom:String)
{
private var listeLivres:MutableList<Livre> = mutableListOf()
    constructor(nom: String,prenom: String,listesLivres:MutableList<Livre>):this(nom,prenom){
        this.listeLivres = listesLivres
    }
    fun ajouterLivres(livre:Livre){
        if(!this.listeLivres.contains(livre)){
            listeLivres.add(livre)
        }

    }
}