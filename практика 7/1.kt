fun main() {
    while (true) {
        print("\n\nВведите 1-ое число (или же 'exit' для выхода): ")
        val input1 = readLine()
        if (input1 == "exit") break
        print("Введите 2-ое число: ")
        val input2 = readLine()
        if (input2 == "exit") break
        val num1 = input1?.toDoubleOrNull()
        val num2 = input2?.toDoubleOrNull()
        if (num1 == null || num2 == null) {
            println("Введите корректные числа.")
            continue
        }
        print("Выберите операцию из предложенных(+, -, *, /): ")
        val operation = readLine()
        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    println("Ошибка: Деление на ноль.")
                    continue
                }
            }
            else -> {
                println("Неверная операция.")
                continue
            }
        }
        println("Результат: $result")
    }
}