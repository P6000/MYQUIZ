package com.example.myquizcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewBtn = findViewById<Button>(R.id.reviewButton)
        val exitBtn = findViewById<Button>(R.id.exitButton)

        scoreText.text = "You scored $score out of 5"

        feedbackText.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practising!"
        }

        reviewBtn.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("QUESTIONS", intent.getStringArrayExtra("QUESTIONS"))
            intent.putExtra("ANSWERS", intent.getBooleanArrayExtra("ANSWERS"))
            intent.putExtra("USER_ANSWERS", intent.getBooleanArrayExtra("USER_ANSWERS"))
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}
