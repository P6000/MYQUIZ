package com.example.myquizcard

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {

    private val questions = arrayOf(
        "Nelson Mandela was president in 1994",
        "The Berlin Wall fell in 1990",
        "Julius Caesar discovered America",
        "World War II ended in 1945",
        "The Great Fire of London happened in 1666"
    )

    private val answers = arrayOf(true, false, false, true, true)


    @Test
    fun testAnswersLogic() {
        var score = 0

        // Simulate user answers
        val userAnswers = arrayOf(true, false, false, true, false) // Last one is wrong

        for (i in questions.indices) {
            if (userAnswers[i] == answers[i]) {
                score++
            }
        }

        assertEquals(4, score)
    }

    @Test
    fun testAllCorrectAnswers() {
        val userAnswers = arrayOf(true, false, false, true, true)

        var score = 0

        for (i in userAnswers.indices) {
            if (userAnswers[i] == answers[i]) {
                score++
            }
        }

        assertEquals(5, score)
    }

    @Test
    fun testAllWrongAnswers() {
        val userAnswers = arrayOf(true, true, false, false, true)
        var score = 0

        for (i in userAnswers.indices) {
            if (userAnswers[i] == answers[i]) {
                score++
            }
        }

        assertEquals(0, score)
    }
}