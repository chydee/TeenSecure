package com.j0t1m4.teensecure.data.contents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Question : Parcelable {
    @Parcelize
    data class MultipleChoice(
        val question: String, val options: List<String>, val correctAnswer: String, val reward: Int
    ) : Question()

    @Parcelize
    data class TrueOrFalse(
        val question: String, val correctAnswer: Boolean, val reward: Int
    ) : Question()

    @Parcelize
    data class ScenarioBased(
        val scenario: String, val question: String, val options: List<String>, val correctAnswer: String, val reward: Int
    ) : Question()

    @Parcelize
    data class Matching(
        val instruction: String,
        val pairs: Map<String, String>, // Left side to right side matching
        val correctAnswer: Map<String, String>,/* = mapOf(
            "Email Phishing" to "Uses emails to trick you into giving away personal information",
            "Message Phishing" to "Uses messages to trick you into giving away information",
            "Fake Website" to "Pretends to be a trusted website to steal your information"
        ),*/
        val reward: Int
    ) : Question()

    @Parcelize
    data class FillInTheBlank(
        val question: String, val correctAnswer: String, val reward: Int
    ) : Question()

    @Parcelize
    data class Visual(
        val imageUrl: List<Int>, val question: String, val options: List<String>, val correctAnswer: String, val reward: Int
    ) : Question()

    @Parcelize
    data class MultipleAnswer(
        val question: String, val options: List<String>, val correctAnswers: List<String>, val reward: Int
    ) : Question()

    @Parcelize
    data class DragAndDrop(
        val question: String = "", val items: List<String>, val correctOrder: List<String>, val reward: Int
    ) : Question()

    @Parcelize
    data class InteractiveQuiz(
        val question: String, val options: List<String>, val correctAnswer: String, val reward: Int
    ) : Question()
}
