package com.example.myquizcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivcity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was president in 1994",
        "The Berlin Wall fell in 1990",
        "Julius Caesar discovered America",
        "World War II ended in 1945",
        "The Great Fire of London happened in 1666"
    )
    private val answers = arrayOf(true, false, false, true, true)

    private var index = 0
    private var score = 0
    private val userAnswers = BooleanArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionText = findViewById<TextView>(R.id.questionText)
        val trueBtn = findViewById<Button>(R.id.trueButton)
        val falseBtn = findViewById<Button>(R.id.falseButton)
        val nextBtn = findViewById<Button>(R.id.nextButton)

        fun displayQuestion() {
            questionText.text = questions[index]
        }

        trueBtn.setOnClickListener {
            checkAnswer(true)
        }

        falseBtn.setOnClickListener {
            checkAnswer(false)
        }

        nextBtn.setOnClickListener {
            if (index < questions.size - 1) {
                index++
                displayQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("ANSWERS", answers)
                intent.putExtra("QUESTIONS", questions)
                intent.putExtra("USER_ANSWERS", userAnswers)
                startActivity(intent)
                finish()
            }
        }

        displayQuestion()
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            score++
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
        }
        userAnswers[index] = userAnswer
    }
}