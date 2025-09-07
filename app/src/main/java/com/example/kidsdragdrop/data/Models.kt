package com.example.kidsdragdrop.data

enum class QuestionType { MULTIPLE_CHOICE_TEXT, MULTIPLE_CHOICE_IMAGE, TRUE_FALSE, DRAG_DROP }

data class QuestionOption(
    val label: String,
    val isCorrect: Boolean
)

data class Question(
    val prompt: String,
    val type: QuestionType,
    val options: List<QuestionOption> = emptyList(),
    val imageRes: Int? = null,
    val trueAnswer: Boolean? = null
    // New fields for drag & drop
    val draggableItems: List<String> = emptyList(),
    val dropTargets: List<String> = emptyList()
)
