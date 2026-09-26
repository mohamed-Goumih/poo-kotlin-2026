package `ep17-v2`

abstract class ItemDeBiliothetique(protected var id:String) {
init {
    require(id.isNotBlank()){"ID ne doit pas etre vide"}
}
}