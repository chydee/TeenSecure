package com.j0t1m4.teensecure.data.contents

sealed class Question {
    data class MultipleChoice(
        val question: String, val options: List<String>, val correctAnswer: String
    ) : Question()

    data class TrueOrFalse(
        val question: String, val correctAnswer: Boolean
    ) : Question()

    data class ScenarioBased(
        val scenario: String, val question: String, val options: List<String>, val correctAnswer: String
    ) : Question()

    data class Matching(
        val pairs: Map<String, String> // Left side to right side matching
    ) : Question()

    data class FillInTheBlank(
        val question: String, val correctAnswer: String
    ) : Question()

    data class Visual(
        val imageUrl: String, val question: String, val correctAnswer: Boolean
    ) : Question()

    data class MultipleAnswer(
        val question: String, val options: List<String>, val correctAnswers: List<String>
    ) : Question()

    data class DragAndDrop(
        val items: List<String>, val correctOrder: List<String>
    ) : Question()

    data class InteractiveQuiz(
        val question: String, val options: List<String>, val correctAnswer: String
    ) : Question()
}
