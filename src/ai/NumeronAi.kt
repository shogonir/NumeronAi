package ai

import game.HistoryRecord

/**
 * Created by shogo on 2017/12/06.
 */
class NumeronAi(level: Int, numDigits: Int, maxDigit: Int) {

    val defaultSolver: NumeronSolverDefault = NumeronSolverDefault(numDigits, maxDigit)
    val solverList: MutableList<NumeronSolver> = mutableListOf()

    init {
        for (i in 1..level) {
            NumeronSolver.fromLevel(i, numDigits, maxDigit)?.let { solverList.add(it) }
        }
    }

    fun generateAnswer(): List<Int> {
        var answer: List<Int> = nextAnswer()
        var loopCount: Int = 0
        while (!isValid(answer)) {
            if (loopCount++ > 100) {
                break
            }
            answer = nextAnswer()
        }
        return answer
    }

    fun isValid(answer: List<Int>): Boolean {
        if (!defaultSolver.isValid(answer)) {
            return false
        }

        for (solver in solverList) {
            if (!solver.isValid(answer)) {
                return false
            }
        }
        return true
    }

    fun historyRecordAddedCallback(historyRecord: HistoryRecord) {
        defaultSolver.historyRecordAddedCallback(historyRecord)
        for (solver in solverList) {
            solver.historyRecordAddedCallback(historyRecord)
        }
    }

    private fun nextAnswer(): List<Int> {
        for (solver in solverList.reversed()) {
            solver.generateAnswer()?.let { return it }
        }
        return defaultSolver.generateAnswer()
    }
}
