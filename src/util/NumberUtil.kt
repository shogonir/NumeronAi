package util

import java.util.*

/**
 * Created by shogo on 2017/12/05.
 */
object NumberUtil {

    fun generateCorrectAnswer(numDigits: Int, maxDigit: Int): List<Int> {
        val answer: MutableList<Int> = mutableListOf()
        for (i in 1..numDigits) {
            var digit: Int = Random().nextInt(maxDigit + 1)
            while (answer.contains(digit)) {
                digit = Random().nextInt(maxDigit + 1)
            }
            answer.add(digit)
        }
        return answer
    }
}
