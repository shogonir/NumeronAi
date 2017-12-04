package game

import util.NumberUtil

/**
 * Created by shogo on 2017/12/04.
 */
class Game(internal val correctAnswer: List<Int>) {

    val numDigits: Int = correctAnswer.size

    val history: MutableList<HistoryRecord> = mutableListOf()

    init {
    }

    fun start() {
        println("correctAnswer=$correctAnswer")
        for (i in 1..10) {
            val numbers: List<Int> = NumberUtil.generateAnswer(numDigits)
            val judgementResult: JudgementResult = judge(numbers)
            history.add(HistoryRecord(numbers, judgementResult))
            println("answer=$numbers judgement=$judgementResult")
        }
    }

    fun judge(answer: List<Int>): JudgementResult {
        if (answer.size != numDigits) {
            return JudgementResult(0, 0)
        }

        var eatCount: Int = 0
        var biteCount: Int = 0
        for (i in 0 until numDigits) {
            if (answer[i] == correctAnswer[i]) {
                eatCount++
                continue
            }
            if (correctAnswer.contains(answer[i])) {
                biteCount++
            }
        }
        return JudgementResult(eatCount, biteCount)
    }
}