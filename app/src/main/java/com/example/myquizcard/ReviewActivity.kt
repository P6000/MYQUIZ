package com.example.myquizcard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val questionList = intent.getStringArrayExtra("QUESTIONS")!!
        val correctAnswers = intent.getBooleanArrayExtra("ANSWERS")!!
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS")!!

        val reviewText = findViewById<TextView>(R.id.reviewText)
        val sb = StringBuilder()

        for (i in questionList.indices) {
            sb.append("${i + 1}. ${questionList[i]}\n")
            sb.append("Your answer: ${userAnswers[i]}\n")
            sb.append("Correct answer: ${correctAnswers[i]}\n\n")
        }

        reviewText.text = sb.toString()
    }
}