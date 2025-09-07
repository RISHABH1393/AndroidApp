package com.example.kidsdragdrop.data

import com.example.kidsdragdrop.R

object QuestionRepository {

    fun allQuestions(): List<Question> {
        return listOf(

            // ---------- DRAG & DROP (10 questions) ----------
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_line,
                draggableItems = listOf("Straight line", "Square", "Curved line", "Parabola"),
                correctAnswer = "Straight line"
            ),
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_circle,
                draggableItems = listOf("Ellipse", "Square", "Circle", "Rectangle"),
                correctAnswer = "Circle"
            ),
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_triangle,
                draggableItems = listOf("Triangle", "Circle", "Line", "Oval"),
                correctAnswer = "Triangle"
            ),
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_rectangle,
                draggableItems = listOf("Square", "Rectangle", "Parabola", "Circle"),
                correctAnswer = "Rectangle"
            ),
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_square,
                draggableItems = listOf("Rectangle", "Triangle", "Square", "Line"),
                correctAnswer = "Square"
            ),
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_rhombus,
                draggableItems = listOf("Rhombus", "Straight line", "Square", "Rectangle"),
                correctAnswer = "Rhombus"
            ),
            Question(
                prompt = "Identify this shape",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_star,
                draggableItems = listOf("Star", "Triangle", "Square", "Circle"),
                correctAnswer = "Star"
            ),
            Question(
                prompt = "Which of the following matches the figure?",
                type = QuestionType.DRAG_DROP,
                imageRes = R.drawable.shape_pentagon,
                draggableItems = listOf("Pentagon", "Hexagon", "Circle", "Square"),
                correctAnswer = "Pentagon"
            ),

            // ---------- MULTIPLE CHOICE / TRUE-FALSE (10 questions) ----------
            Question(
                prompt = "What is 6 + 7?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("12", false),
                    QuestionOption("13", true),
                    QuestionOption("14", false),
                    QuestionOption("15", false)
                )
            ),
            Question(
                prompt = "What is 15 - 8?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("6", false),
                    QuestionOption("7", true),
                    QuestionOption("8", false),
                    QuestionOption("9", false)
                )
            ),
            Question(
                prompt = "What is 5 × 3?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("8", false),
                    QuestionOption("10", false),
                    QuestionOption("15", true),
                    QuestionOption("20", false)
                )
            ),
            Question(
                prompt = "What is 20 ÷ 4?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("4", true),
                    QuestionOption("5", false),
                    QuestionOption("6", false),
                    QuestionOption("7", false)
                )
            ),
            Question(
                prompt = "Is 12 an even number?",
                type = QuestionType.TRUE_FALSE,
                trueAnswer = true
            ),
            Question(
                prompt = "Is 19 divisible by 2?",
                type = QuestionType.TRUE_FALSE,
                trueAnswer = false
            ),
            Question(
                prompt = "Which shape has 4 equal sides?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("Triangle", false),
                    QuestionOption("Rectangle", false),
                    QuestionOption("Square", true),
                    QuestionOption("Circle", false)
                )
            ),
            Question(
                prompt = "How many sides does a hexagon have?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("5", false),
                    QuestionOption("6", true),
                    QuestionOption("7", false),
                    QuestionOption("8", false)
                )
            ),
            Question(
                prompt = "Is 50 greater than 100?",
                type = QuestionType.TRUE_FALSE,
                trueAnswer = false
            ),
            Question(
                prompt = "What comes after 89?",
                type = QuestionType.MULTIPLE_CHOICE_TEXT,
                options = listOf(
                    QuestionOption("88", false),
                    QuestionOption("89", false),
                    QuestionOption("90", true),
                    QuestionOption("91", false)
                )
            )
        )
    }
}
