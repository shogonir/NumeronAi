package util

import java.util.*

/**
 * Created by shogo on 2017/12/05.
 */
object NumberUtil {

    val Base10: Int = 10

    fun generateAnswer(numDigits: Int): List<Int> {
        val answer: MutableList<Int> = mutableListOf()
        for (i in 1..numDigits) {
            var digit: Int = Random().nextInt(Base10)
            while (answer.contains(digit)) {
                digit = Random().nextInt(Base10)
            }
            answer.add(digit)
        }
        return answer
    }
}