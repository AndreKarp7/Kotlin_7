fun score(str:String, a:Int):Int {
    return when (str){
        "win" -> a * 3
        "draw" -> a
        "lose" -> 0
        else -> 0
    }
}
fun main(){
    var s = 0
    print("Введите кол-во побед: ")
    s += score("win", readln().toInt())
    print("Введите кол-во ничьих: ")
    s += score("draw", readln().toInt())
    print("Введите кол-во поражений: ")
    s += score("lose", readln().toInt())
    println("\n\nКол-во очков состовляет: $s")
}
