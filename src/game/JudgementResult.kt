package game

/**
 * Created by shogo on 2017/12/05.
 */
class JudgementResult(val eat: Int, val bite: Int) {

    fun eatOrBite(): Int {
        return eat + bite
    }

    override fun toString(): String {
        return "JudgementResult(eat=$eat, bite=$bite)"
    }
}
