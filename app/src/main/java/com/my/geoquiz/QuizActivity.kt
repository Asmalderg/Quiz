package com.my.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class QuizActivity : AppCompatActivity() {
   init {
        val trueButton  :Button
        val falseButton :Button
        val nextButton  :Button
        var questionTextView    :TextView

        val question = Array<Question> (5){
            Question(R.string.question_Australia, true)
            Question(R.string.question_oceans, true)
            Question(R.string.question_Africa, false)
            Question(R.string.question_americas,true)
            Question(R.string.question_asia, true)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton  :Button = findViewById(R.id.true_button)
        val falseButton :Button = findViewById(R.id.false_button)



//        trueButton.setOnClickListener {
//            val tst = Toast.makeText(
//                    this,
//                    R.string.correct_toast,
//                    Toast.LENGTH_SHORT);
//            tst.setGravity(Gravity.TOP, 0, 0)
//            tst.show()
//        }
//
//        falseButton.setOnClickListener {
//            val tst = Toast.makeText(
//                this,
//                R.string.incorrect_toast,
//                Toast.LENGTH_SHORT);
//                tst.setGravity(Gravity.TOP, 0, 0)
//                tst.show()
//        }
    }
}
