package ai

import game.HistoryRecord
import game.JudgementResult
import java.util.*

/**
 * Created by shogo on 2017/12/06.
 */
class NumeronSolverLevel1(numDigits: Int, maxDigit: Int) : NumeronSolver(numDigits, maxDigit) {

    val unusableNumberList: MutableList<Int> = mutableListOf()

    init {

    }

    override fun generateAnswer(): List<Int>? {
        val answer: MutableList<Int> = mutableListOf()

        while (answer.size < numDigits) {
            var number: Int = Random().nextInt(maxDigit + 1)
            while (answer.contains(number) || unusableNumberList.contains(number)) {
                number = Random().nextInt(maxDigit + 1)
            }
            answer.add(number)
        }
        return answer
    }

    override fun isValid(answer: List<Int>): Boolean {
        for (number in answer) {
            if (unusableNumberList.contains(number)) {
                return false
            }
        }
        return true
    }

    override fun historyRecordAddedCallback(historyRecord: HistoryRecord) {
        val judgement: JudgementResult = historyRecord.judgement
        if (judgement.eatOrBite() != 0) {
            return
        }

        for (number in historyRecord.answer) {
            if (!unusableNumberList.contains(number)) {
                unusableNumberList.add(number)
            }
        }
    }
}