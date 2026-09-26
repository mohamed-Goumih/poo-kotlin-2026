package `ep17-v2`

class Auteur( private var nom:String, private var prenom:String)
{
private var listeLivres:MutableList<Livre> = mutableListOf()
    constructor(nom: String,prenom: String,listesLivres:MutableList<Livre>):this(nom,prenom){
        this.listeLivres = listesLivres
    }
    fun getNom():String = nom
    fun setNom(nom:String){this.nom = nom}
    fun getPrenom():String = prenom
    fun setPrenom(prenom:String){this.prenom = prenom}

    fun ajouterLivres(livre:Livre){
        if(!this.listeLivres.contains(livre)){
            listeLivres.add(livre)
        }

    }
}