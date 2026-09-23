open class Vehicle {
    open fun drive(){
        println("je suis en route")
    }
}
class Car:Vehicle() {
    override fun drive(){
        println("le car est en route")
    }

}

fun main() {
    val v=Vehicle()
}