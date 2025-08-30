package com.jimmy.myfirstapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        val nimDisplay = findViewById<TextView>(R.id.nim_display)
        val requiredLength = 11

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)?.text.toString().trim()
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)?.text.toString().trim()

//            if(nameInput.isNotEmpty()){
//                nameDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
//            }
//            else {
//                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_SHORT).apply {
//                    setGravity(Gravity.CENTER, 0, 0)
//                    show()
//                }
//            }

            when {
                // Case 1: Name field is blank
                nameInput.isBlank() -> {
                    Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_SHORT).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                }

                // Case 2: NIM field is blank.
                nimInput.isBlank() -> {
                    Toast.makeText(this, getString(R.string.nim_empty), Toast.LENGTH_SHORT).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                }

                // Case 3: NIM length is wrong.
                nimInput.length != requiredLength -> {
                    Toast.makeText(this, getString(R.string.nim_length), Toast.LENGTH_SHORT).apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                }

                // Success Case: All checks passed.
                else -> {
                    nameDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
                    nimDisplay?.text = getString(R.string.nim_greet).plus(" ").plus(nimInput)
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}