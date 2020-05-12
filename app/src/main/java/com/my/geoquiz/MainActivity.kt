package com.my.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton  :Button = findViewById(R.id.true_button)
        val falseButton :Button = findViewById(R.id.false_button)

        trueButton.setOnClickListener {  Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT).show() }

        falseButton.setOnClickListener {   Toast.makeText(
            this,
            R.string.incorrect_toast,
            Toast.LENGTH_SHORT).show() }
    }
}
