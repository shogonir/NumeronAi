package ai

import game.HistoryRecord
import java.util.*

/**
 * Created by shogo on 2017/12/06.
 */
class NumeronSolverDefault(numDigits: Int, maxDigit: Int): NumeronSolver(numDigits, maxDigit) {

    val pastAnswerList: MutableList<List<Int>> = mutableListOf()

    init {

    }

    override fun generateAnswer(): List<Int> {
        val answer: MutableList<Int> = mutableListOf()
        while (answer.size < numDigits) {
            var number: Int = Random().nextInt(maxDigit + 1)
            while (answer.contains(number)) {
                number = Random().nextInt(maxDigit + 1)
            }
            answer.add(number)
        }
        return answer
    }

    override fun isValid(answer: List<Int>): Boolean {
        return !pastAnswerList.contains(answer)
    }

    override fun historyRecordAddedCallback(historyRecord: HistoryRecord) {
        if (pastAnswerList.contains(historyRecord.answer)) {
            return
        }
        pastAnswerList.add(historyRecord.answer)
    }
}