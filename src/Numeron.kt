import game.Game
import util.NumberUtil

/**
 * Created by shogo on 2017/12/04.
 */
fun main(args: Array<String>) {
    val game: Game = Game(numDigits=3, maxDigit=9)
    game.start()
}
