package ep17

class Livre (private val titre :String,
             private val isbn:String,
             auteur: Auteur)
{
   fun getTitle():String{
       return this.titre
   }
    //getters & setters

}
