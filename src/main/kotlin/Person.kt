//open class Person(val name:String){
//    //Atribus ou proprietes
//    var age:Int=0
//    var gender:String=""
//    constructor(nom: String, age: Int) : this(nom) {
//        this.age=age
//    }
//    constructor(nom: String, age: Int, gender:String) : this(nom,age) {
//        this.gender=gender
//    }
//    //methodes
//    fun afficher(){
//        println("les donnés de la personne sont :${this.name} ${this.gender} ${this.age}")
//    }
//}
//
////classe Stagiaire
//class Stagiaire( val name:String)
//    :Person(name) {
//    var filiere:String=""
//    constructor(nom: String, age: Int,filiere:String) : super(nom,age) {
//      this.filiere=filiere
//    }
//
//
//}
//
//fun main() {
//    //creation des objets
//    //instancier une classe
//    val p=Person("Ahmed")
//    println(p.name)
//    val p1=Person("Sara",23)
//    val p2=Person("Mohamed",45,"Homme")
//
//    //p.name="Ali"
//    p1.age=30
//    p2.age=40
//    println(p2.age)
//    p2.afficher()
//}