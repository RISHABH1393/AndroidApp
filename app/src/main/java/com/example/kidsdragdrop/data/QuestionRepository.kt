package com.example.kidsdragdrop.data

import com.example.kidsdragdrop.R

object QuestionRepository {

    fun allQuestions(): List<Question> = listOf(
        // 1
        Question(
            prompt = "How many corners does a square have?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            imageRes = R.drawable.shape_square,
            options = listOf(
                QuestionOption("2", false),
                QuestionOption("3", false),
                QuestionOption("4", true),
                QuestionOption("5", false)
            )
        ),
        // 2
        Question(
            prompt = "Find the circle. Which letter points to the circle?",
            type = QuestionType.MULTIPLE_CHOICE_IMAGE,
            imageRes = R.drawable.shape_collage,
            options = listOf(
                QuestionOption("A", false), // square
                QuestionOption("B", true),  // circle
                QuestionOption("C", false), // triangle
                QuestionOption("D", false)
            )
        ),
        // 3
        Question(
            prompt = "A triangle has 3 sides.",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = true
        ),
        // 4
        Question(
            prompt = "Which shape has no corners?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("Square", false),
                QuestionOption("Circle", true),
                QuestionOption("Triangle", false),
                QuestionOption("Rectangle", false)
            )
        ),
        // 5
        Question(
            prompt = "Find the square. Which letter points to the square?",
            type = QuestionType.MULTIPLE_CHOICE_IMAGE,
            imageRes = R.drawable.shape_collage,
            options = listOf(
                QuestionOption("A", true),
                QuestionOption("B", false),
                QuestionOption("C", false),
                QuestionOption("D", false)
            )
        ),
        // 6
        Question(
            prompt = "A rectangle always has 4 sides.",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = true
        ),
        // 7
        Question(
            prompt = "How many sides does a triangle have?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("2", false),
                QuestionOption("3", true),
                QuestionOption("4", false),
                QuestionOption("5", false)
            )
        ),
        // 8
        Question(
            prompt = "Find the triangle. Which letter points to the triangle?",
            type = QuestionType.MULTIPLE_CHOICE_IMAGE,
            imageRes = R.drawable.shape_collage,
            options = listOf(
                QuestionOption("A", false),
                QuestionOption("B", false),
                QuestionOption("C", true),
                QuestionOption("D", false)
            )
        ),
        // 9
        Question(
            prompt = "A circle has straight sides.",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = false
        ),
        // 10
        Question(
            prompt = "Which shape has 4 equal sides?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("Square", true),
                QuestionOption("Rectangle", false),
                QuestionOption("Triangle", false),
                QuestionOption("Oval", false)
            )
        ),
        // 11
        Question(
            prompt = "Is the sun shaped like a circle?",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = true
        ),
        // 12
        Question(
            prompt = "Which one is round?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("Circle", true),
                QuestionOption("Square", false),
                QuestionOption("Triangle", false),
                QuestionOption("Rectangle", false)
            )
        ),
        // 13
        Question(
            prompt = "A triangle has 4 corners.",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = false
        ),
        // 14
        Question(
            prompt = "How many corners does a triangle have?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("1", false),
                QuestionOption("2", false),
                QuestionOption("3", true),
                QuestionOption("4", false)
            )
        ),
        // 15
        Question(
            prompt = "Which shape looks like a box face-on?",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("Square", true),
                QuestionOption("Triangle", false),
                QuestionOption("Circle", false),
                QuestionOption("Line", false)
            )
        ),
        // 16
        Question(
            prompt = "Is a square also a rectangle? (Hint: all sides equal but still 4 right angles)",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = true
        ),
        // 17
        Question(
            prompt = "Find the shape with 3 corners.",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("Triangle", true),
                QuestionOption("Circle", false),
                QuestionOption("Square", false),
                QuestionOption("Rectangle", false)
            )
        ),
        // 18
        Question(
            prompt = "Find the shape with 0 corners.",
            type = QuestionType.MULTIPLE_CHOICE_TEXT,
            options = listOf(
                QuestionOption("Circle", true),
                QuestionOption("Triangle", false),
                QuestionOption("Square", false),
                QuestionOption("Rectangle", false)
            )
        ),
        // 19
        Question(
            prompt = "A rectangle can have two long sides and two short sides.",
            type = QuestionType.TRUE_FALSE,
            trueAnswer = true
        ),
        // 20
        Question(
            prompt = "Count the sides of this shape.",
            type = QuestionType.MULTIPLE_CHOICE_IMAGE,
            imageRes = R.drawable.shape_square,
            options = listOf(
                QuestionOption("2", false),
                QuestionOption("3", false),
                QuestionOption("4", true),
                QuestionOption("6", false)
            )
        )
                // --- new drag & drop questions ---
        // 21
        Question(
            prompt = "Drag the circle into the box",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Circle", "Square", "Triangle"),
            correctAnswer = "Circle"
        ),
        // 22
        Question(
            prompt = "Drag the apple into the basket",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Apple", "Banana", "Orange"),
            correctAnswer = "Apple"
        ),
        // 23
        Question(
            prompt = "Drag the number 5",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("3", "5", "7"),
            correctAnswer = "5"
        ),
        // 24
        Question(
            prompt = "Drag the red color",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Red", "Blue", "Green"),
            correctAnswer = "Red"
        ),
        // 25
        Question(
            prompt = "Drag the biggest animal",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Cat", "Dog", "Elephant"),
            correctAnswer = "Elephant"
        ),
        // 26
        Question(
            prompt = "Drag the triangle shape",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Circle", "Triangle", "Square"),
            correctAnswer = "Triangle"
        ),
        // 27
        Question(
            prompt = "Drag the letter A",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("A", "B", "C"),
            correctAnswer = "A"
        ),
        // 28
        Question(
            prompt = "Drag the fruit",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Car", "Ball", "Mango"),
            correctAnswer = "Mango"
        ),
        // 29
        Question(
            prompt = "Drag the number that comes after 2",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("1", "3", "5"),
            correctAnswer = "3"
        ),
        // 30
        Question(
            prompt = "Drag the object used to write",
            type = QuestionType.DRAG_DROP,
            draggableItems = listOf("Pen", "Spoon", "Cup"),
            correctAnswer = "Pen"
        )
    )
}
