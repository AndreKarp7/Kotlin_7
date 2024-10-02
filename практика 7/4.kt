data class Card(val rank: String)
class Deck{
    private val ranks = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз")
    private val cards = ranks.map { Card(it) }.shuffled().toMutableList()
    fun draw(): Card? = if (cards.isNotEmpty()) cards.removeAt(0) else null
}
fun calcScore(hand: List<Card>): Int{
    var score = hand.sumOf {
        when (it.rank) {
            "Валет", "Дама", "Король" -> 10
            "Туз" -> 11
            else -> it.rank.toInt()
        }
    }
    var aces = hand.count { it.rank == "Туз" }
    while (score > 21 && aces > 0) {
        score -= 10
        aces--
    }
    return score
}
fun main(){
    val deck = Deck()
    var playerHand = mutableListOf<Card>()
    var dealerHand = mutableListOf<Card>()
    repeat(2){
        playerHand.add(deck.draw()!!)
        dealerHand.add(deck.draw()!!)
    }
    while (true) {
        println("Ваши карты: ${playerHand.joinToString()} (Счет: ${calcScore(playerHand)})")
        if (calcScore(playerHand) > 21) {
            println("Вы проиграли!")
            return
        }
        print("Хотите взять карту? (да/нет): ")
        if (readLine()?.trim()?.toLowerCase() != "да") break
        playerHand.add(deck.draw()!!)
    }

    while (calcScore(dealerHand) < 17) dealerHand.add(deck.draw()!!)

    val playerScore = calcScore(playerHand)
    val dealerScore = calcScore(dealerHand)

    println("Ваш счёт: $playerScore, счёт дилера: $dealerScore")
    when {
        playerScore > 21 -> println("Вы проиграли!")
        dealerScore > 21 -> println("Вы выиграли!")
        playerScore > dealerScore -> println("Вы выиграли!")
        dealerScore > playerScore -> println("Дилер выиграл!")
        else -> println("Ничья!")
    }

}