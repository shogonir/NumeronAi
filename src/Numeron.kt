import game.Game
import util.NumberUtil

/**
 * Created by shogo on 2017/12/04.
 */
fun main(args: Array<String>) {
    val numDigits: Int = 3
    val answer: List<Int> = NumberUtil.generateAnswer(numDigits)
    val game: Game = Game(answer)
    game.start()
}
