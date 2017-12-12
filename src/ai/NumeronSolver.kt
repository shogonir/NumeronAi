package ai

import game.HistoryRecord

/**
 * Created by shogo on 2017/12/06.
 */
abstract class NumeronSolver(val numDigits: Int, val maxDigit: Int) {

    abstract fun generateAnswer(): List<Int>?

    abstract fun isValid(answer: List<Int>): Boolean

    abstract fun historyRecordAddedCallback(historyRecord: HistoryRecord)

    companion object {

        fun fromLevel(level: Int, numDigits: Int, maxDigit: Int): NumeronSolver? {
            return when (level) {
                0 -> NumeronSolverDefault(numDigits, maxDigit)
                1 -> NumeronSolverLevel1(numDigits, maxDigit)
                else -> null
            }
        }
    }
}
