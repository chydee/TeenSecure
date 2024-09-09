package com.j0t1m4.teensecure.core.mechanism


class Game {

    private var correctAnswersCount: Int = 0
    private var score: Int = 0
    private val passMark = 70
    var totalQuestions = 0  // You can adjust this based on your game's logic

    fun addScore(reward: Int, isCorrect: Boolean) {
        score += reward
        if (isCorrect) {
            correctAnswersCount++
        }
    }

    fun hasPassed(): Boolean {
        return score >= (totalQuestions * passMark / 100)
    }

    // Get total score at the end of the game
    fun getTotalScore(): Int {
        return score
    }

    // Get the number of correct answers at the end of the game
    fun getCorrectAnswersCount(): Int {
        return correctAnswersCount
    }
}
