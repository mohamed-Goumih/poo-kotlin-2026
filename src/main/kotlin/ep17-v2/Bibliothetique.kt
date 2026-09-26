package `ep17-v2`

 class Bibliothetique {
     private var livres: MutableMap<String,Livre> = mutableMapOf()
     private var auteurs: MutableMap<String, Auteur> = mutableMapOf()
     var cL=1
     var cA=1
     var keyLivre:String="L"+cL
     var keyAuteur:String="A"+cA
     fun ajouterLivres(livre:Livre){
     this.livres.put(keyLivre,livre)
         cL++
     }
     fun ajouterAuteur(auteur:Auteur){
      this.auteurs.put(keyAuteur,auteur)
         cA++
     }
     //keyLivre :L1->livre1 L2->livre2
     fun rechercherLivreParAuteur(nomAuteur:String):List<Livre>{
      return this.livres.filter{it.key==nomAuteur}.values.toList()
     }
     //keyLivre:L1 ->Livre100
     fun mettreAjourLivre(id:String,nouveauLivre:Livre):Boolean{
         this.livres[id]=nouveauLivre
         //this.livres.set(keyLivre,nouveauLivre)
         return true
     }

     fun supprimerLivre(id:String):Boolean{
         if(id in livres.keys) livres.remove(id)
         return true
     }

     fun afficherTousLesLivres(){
    for(livre in livres){
        println("${livre.value.afficherInfo()}")
    }
     }

}