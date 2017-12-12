package game

import ai.NumeronAi
import org.jetbrains.annotations.Mutable
import util.NumberUtil

/**
 * Created by shogo on 2017/12/04.
 */
class Game(val numDigits: Int, val maxDigit: Int) {

    val correctAnswer: List<Int>

    init {
        correctAnswer = NumberUtil.generateCorrectAnswer(numDigits, maxDigit)
    }

    fun start() {
        println("correctAnswer=$correctAnswer")

        val ai: NumeronAi = NumeronAi(1, numDigits, maxDigit)
        var phase: Int = 0

        while (true) {
            val answer: List<Int> = ai.generateAnswer()
            val judgement: JudgementResult = judge(answer)

            phase++
            println("$phase $answer $judgement")

            val historyRecord: HistoryRecord = HistoryRecord(answer, judgement)
            ai.historyRecordAddedCallback(historyRecord)

            if (judgement.eat == numDigits) {
                break
            }
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
