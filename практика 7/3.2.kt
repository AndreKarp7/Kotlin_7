fun trueOfFalse(a:Int, b:Int):Boolean{
    return when{
        a == b -> true
        else -> false
    }
}
fun main(){
    print("Введите 1-ое число: ")
    var a = readln().toInt()
    print("Введите 2-ое число: ")
    var b = readln().toInt()
    println("\n${trueOfFalse(a, b)}")
}
