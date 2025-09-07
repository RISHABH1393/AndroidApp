package com.example.kidsdragdrop

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class Question(
    val id: Int,
    val imageRes: Int,
    val prompt: String,
    val options: List<String>,
    val answerIndex: Int
)

class MainActivity : AppCompatActivity() {
    private lateinit var questionImage: ImageView
    private lateinit var promptText: TextView
    private lateinit var dropTarget: FrameLayout
    private lateinit var optionViews: List<TextView>
    private lateinit var scoreText: TextView
    private val originalPositions = mutableListOf<Pair<Float, Float>>()

    private val questions = listOf(
        Question(1, R.drawable.shape_straight_line, "Which of the following matches the figure?", listOf("Straight line","Square","Curved line","Parabola"), 0),
        Question(2, R.drawable.shape_parabola, "Which of the following matches the figure?", listOf("Circle","Parabola","Triangle","Line"), 1),
        Question(3, R.drawable.shape_circle, "Which of the following matches the figure?", listOf("Ellipse","Square","Circle","Rectangle"), 2),
        Question(4, R.drawable.shape_triangle, "Which of the following matches the figure?", listOf("Triangle","Circle","Line","Oval"), 0),
        Question(5, R.drawable.shape_rectangle, "Which of the following matches the figure?", listOf("Square","Rectangle","Parabola","Circle"), 1),
        Question(6, R.drawable.shape_square, "Which of the following matches the figure?", listOf("Rectangle","Triangle","Square","Line"), 2)
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = findViewById<View>(R.id.rootLayout)
        questionImage = findViewById(R.id.questionImage)
        promptText = findViewById(R.id.questionText)
        dropTarget = findViewById(R.id.dropTarget)
        scoreText = findViewById(R.id.scoreText)

        optionViews = listOf(
            findViewById(R.id.option1),
            findViewById(R.id.option2),
            findViewById(R.id.option3),
            findViewById(R.id.option4)
        )

        root.post {
            originalPositions.clear()
            for (v in optionViews) {
                originalPositions.add(Pair(v.x, v.y))
            }
            loadQuestion()
        }

        for ((index, v) in optionViews.withIndex()) {
            setDragListener(v, index)
        }
    }

    private fun loadQuestion() {
        val q = questions[currentIndex]
        questionImage.setImageResource(q.imageRes)
        promptText.text = q.prompt
        updateScoreText()

        for (i in 0 until optionViews.size) {
            if (i < q.options.size) {
                optionViews[i].text = q.options[i]
            } else {
                optionViews[i].text = ""
            }

            if (i < originalPositions.size) {
                optionViews[i].x = originalPositions[i].first
                optionViews[i].y = originalPositions[i].second
            }

            optionViews[i].isEnabled = true
            optionViews[i].alpha = 1f
        }
    }

    private fun updateScoreText() {
        scoreText.text = "Score: $score/${questions.size}"
    }

    private fun setDragListener(view: View, optionIndex: Int) {
        var lastX = 0f
        var lastY = 0f
        var initialX = 0f
        var initialY = 0f

        view.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = event.rawX
                    lastY = event.rawY
                    initialX = v.x
                    initialY = v.y
                    v.parent.requestDisallowInterceptTouchEvent(true)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    val dx = event.rawX - lastX
                    val dy = event.rawY - lastY
                    v.x = v.x + dx
                    v.y = v.y + dy
                    lastX = event.rawX
                    lastY = event.rawY
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.parent.requestDisallowInterceptTouchEvent(false)

                    val viewLoc = IntArray(2)
                    val dropLoc = IntArray(2)
                    v.getLocationOnScreen(viewLoc)
                    dropTarget.getLocationOnScreen(dropLoc)

                    val viewCenterX = viewLoc[0] + v.width / 2
                    val viewCenterY = viewLoc[1] + v.height / 2

                    val dropLeft = dropLoc[0]
                    val dropTop = dropLoc[1]
                    val dropRight = dropLeft + dropTarget.width
                    val dropBottom = dropTop + dropTarget.height

                    if (viewCenterX in dropLeft..dropRight && viewCenterY in dropTop..dropBottom) {
                        val q = questions[currentIndex]
                        if (optionIndex == q.answerIndex) {
                            val targetX = dropTarget.x + (dropTarget.width - v.width) / 2
                            val targetY = dropTarget.y + (dropTarget.height - v.height) / 2
                            v.animate().x(targetX).y(targetY).setDuration(300).start()
                            v.isEnabled = false
                            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                            score += 1
                            updateScoreText()
                            Handler(Looper.getMainLooper()).postDelayed({
                                nextQuestion()
                            }, 800)
                        } else {
                            v.animate().x(initialX).y(initialY).setDuration(300).start()
                            Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        v.animate().x(initialX).y(initialY).setDuration(200).start()
                    }

                    true
                }
                else -> false
            }
        }
    }

    private fun nextQuestion() {
        currentIndex++
        if (currentIndex >= questions.size) {
            Toast.makeText(this, "Well done! You've completed the quiz.", Toast.LENGTH_LONG).show()
            currentIndex = 0
            score = 0
        }
        loadQuestion()
    }
}
