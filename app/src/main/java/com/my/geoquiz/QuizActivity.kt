package com.my.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast


class QuizActivity : AppCompatActivity() {
    companion object {
        val KEY_INDEX = "index"
        val TAG = "QuizActivity"
    }
        var currentIndex :Int      = 0
        var trueButton   :Button?  = null
        var falseButton  :Button?  = null
        var nextButton   :ImageButton?  = null
        var prevousButton:ImageButton? = null

        private val questionBank = arrayOf(
            Question(R.string.question_Australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_Africa, false),
            Question(R.string.question_americas,true),
            Question(R.string.question_asia, true))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate(Bundle) called")

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX, 0)
        }

        updateQuestion()

        trueButton = findViewById(R.id.true_button)
        trueButton?.setOnClickListener {
            isAnswerRight(true)
        }

        falseButton  = findViewById(R.id.false_button)
        falseButton?.setOnClickListener {
            isAnswerRight(false)
        }

        prevousButton = findViewById(R.id.previous_button)
        prevousButton?.setOnClickListener {
            currentIndex = (currentIndex + (questionBank.size - 1)) % questionBank.size
            updateQuestion()
        }

        nextButton = findViewById(R.id.next_button)
        nextButton?.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
    }

    private fun updateQuestion() {
        var questionTextView :TextView? = findViewById(R.id.question_text_view)
        val quest = questionBank[currentIndex].textResId
        questionTextView?.setText(quest)
    }

    private fun isAnswerRight(answer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answerTrue
        var toast: Toast?= null
        if (correctAnswer == answer) {
            toast = Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT);
        } else {
            toast = Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT);
        }

        toast.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
        outState.putInt(KEY_INDEX, currentIndex)
    }

}

