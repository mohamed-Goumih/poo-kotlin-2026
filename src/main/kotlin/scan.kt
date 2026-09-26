package `ep17-v2`

fun main() {
    val nums=listOf(1,2,3,4,5,6,7,8,9,10)
    val steps=nums.scan(0){acc, i -> acc + i }
    println(steps)
}