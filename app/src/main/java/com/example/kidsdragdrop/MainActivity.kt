package com.example.kidsdragdrop

import android.content.ClipData
import android.graphics.Typeface
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.example.kidsdragdrop.data.Question
import com.example.kidsdragdrop.data.QuestionOption
import com.example.kidsdragdrop.data.QuestionRepository
import com.example.kidsdragdrop.data.QuestionType
import com.example.kidsdragdrop.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionQuestions: MutableList<Question>
    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startNewSession()

        binding.btnNext.setOnClickListener {
            if (currentIndex < sessionQuestions.size - 1) {
                currentIndex++
                showQuestion()
            } else {
                showResult()
            }
        }
    }

    private fun startNewSession() {
        val all = QuestionRepository.allQuestions().shuffled(Random(System.currentTimeMillis()))
        sessionQuestions = all.take(5).toMutableList()
        currentIndex = 0
        score = 0
        showQuestion()
    }

    private fun showQuestion() {
        val q = sessionQuestions[currentIndex]
        answered = false
        binding.tvQuestion.text = "Q${currentIndex + 1}. ${q.prompt}"

        // Image handling
        if (q.imageRes != null) {
            binding.ivQuestion.setImageResource(q.imageRes)
            binding.ivQuestion.visibility = View.VISIBLE
        } else {
            binding.ivQuestion.visibility = View.GONE
        }

        // Clear previous options
        binding.optionsContainer.removeAllViews()

        when (q.type) {
            QuestionType.MULTIPLE_CHOICE_TEXT -> {
                q.options.forEachIndexed { index, opt ->
                    val btn = makeOptionButton("${'A' + index}. ${opt.label}")
                    btn.setOnClickListener { onAnswerSelected(opt.isCorrect, btn) }
                    binding.optionsContainer.addView(btn)
                }
            }
            QuestionType.MULTIPLE_CHOICE_IMAGE -> {
                q.options.forEachIndexed { index, opt ->
                    val btn = makeOptionButton(opt.label)
                    btn.setOnClickListener { onAnswerSelected(opt.isCorrect, btn) }
                    binding.optionsContainer.addView(btn)
                }
            }
            QuestionType.TRUE_FALSE -> {
                val trueBtn = makeOptionButton(getString(R.string.true_text))
                val falseBtn = makeOptionButton(getString(R.string.false_text))
                trueBtn.setOnClickListener { onAnswerSelected(q.trueAnswer == true, trueBtn) }
                falseBtn.setOnClickListener { onAnswerSelected(q.trueAnswer == false, falseBtn) }
                binding.optionsContainer.addView(trueBtn)
                binding.optionsContainer.addView(falseBtn)
            }
            QuestionType.DRAG_DROP -> {
                // Drop target
                val dropTarget = TextView(this).apply {
                    text = "⬇️ Drop your answer here"
                    textSize = 22f
                    setPadding(50)
                    setBackgroundColor(0xFFE0E0E0.toInt())
                }

                dropTarget.setOnDragListener { view, event ->
                    when (event.action) {
                        DragEvent.ACTION_DROP -> {
                            val draggedText = event.clipData.getItemAt(0).text.toString()
                            if (!answered) {
                                answered = true
                                if (draggedText == q.correctAnswer) {
                                    score++
                                    (view as TextView).text = "✅ Correct! $draggedText"
                                    view.setBackgroundColor(getColor(R.color.teal_200))
                                } else {
                                    (view as TextView).text = "❌ Wrong! $draggedText"
                                    view.setBackgroundColor(0xFFFF8A80.toInt())
                                }
                            }
                            true
                        }
                        else -> true
                    }
                }

                binding.optionsContainer.addView(dropTarget)

                // Draggable items
                q.draggableItems.forEach { item ->
                    val dragBtn = makeOptionButton(item)
                    dragBtn.setOnLongClickListener {
                        val data = ClipData.newPlainText("label", item)
                        it.startDragAndDrop(data, View.DragShadowBuilder(it), null, 0)
                        true
                    }
                    binding.optionsContainer.addView(dragBtn)
                }
            }
        }
    }

    private fun onAnswerSelected(isCorrect: Boolean, selected: Button) {
        if (answered) return
        answered = true
        if (isCorrect) {
            score++
            selected.setBackgroundColor(getColor(R.color.teal_200))
        } else {
            selected.setBackgroundColor(0xFFFF8A80.toInt())
        }
    }

    private fun showResult() {
        setContentView(R.layout.fragment_result)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val btnRestart: Button = findViewById(R.id.btnRestart)
        tvScore.text = "You scored $score out of ${sessionQuestions.size}!"
        btnRestart.setOnClickListener {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            startNewSession()
            binding.btnNext.text = getString(R.string.next)
        }
    }

    private fun makeOptionButton(text: String): Button {
        val btn = Button(this)
        btn.text = text
        btn.textSize = 20f
        btn.typeface = Typeface.DEFAULT_BOLD
        btn.setPadding(24)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 12, 0, 12)
        btn.layoutParams = params
        return btn
    }
}
