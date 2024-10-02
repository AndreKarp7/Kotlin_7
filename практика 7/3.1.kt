fun main() {
    println("Введите через пробел список чисел : ")
    val input = readLine()
    val numbers: List<Int> = input?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
    if (numbers.isNotEmpty()) {
        val min = numbers.minOrNull()
        println("Наименьшее число в массиве: $min")
    } else {
        println("Список чисел не содержит.")
    }
}