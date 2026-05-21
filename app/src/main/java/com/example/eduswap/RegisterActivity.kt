package com.example.eduswap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        // CONNECT VIEWS

        val etName =
            findViewById<EditText>(
                R.id.etName
            )

        val etEmail =
            findViewById<EditText>(
                R.id.etEmail
            )

        val etUniversity =
            findViewById<EditText>(
                R.id.etUniversity
            )

        val btnRegister =
            findViewById<Button>(
                R.id.btnRegister
            )

        // REGISTER BUTTON

        btnRegister.setOnClickListener {

            val name =
                etName.text.toString()

            val email =
                etEmail.text.toString()

            val university =
                etUniversity.text.toString()

            // VALIDATION

            if (name.isEmpty()) {

                etName.error =
                    "Enter your name"

                return@setOnClickListener

            }

            if (email.isEmpty()) {

                etEmail.error =
                    "Enter your email"

                return@setOnClickListener

            }

            if (university.isEmpty()) {

                etUniversity.error =
                    "Enter your university"

                return@setOnClickListener

            }

            // SAVE USER DATA

            UserData.name = name

            UserData.email = email

            UserData.university = university

            // GO TO HOME SCREEN

            val intent =
                Intent(
                    this,
                    HomeActivity::class.java
                )

            Toast.makeText(
                this,
                "Registration Successful!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(intent)

        }

    }
}