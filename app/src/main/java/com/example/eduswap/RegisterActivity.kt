package com.example.eduswap

// Allows navigation between screens
import android.content.Intent

// Used when the activity starts
import android.os.Bundle

// UI components used in this screen
import android.widget.Button
import android.widget.EditText

// Base class for Android activities
import androidx.appcompat.app.AppCompatActivity

// Shows popup feedback messages
import android.widget.Toast

/*
    RegisterActivity allows the user
    to create a simple profile before
    entering the app.

    The user's:
    - name
    - email
    - university

    are temporarily stored in UserData.
*/

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity
        // to activity_register.xml
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

            // Gets entered text

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

            // Opens home screen

            val intent =
                Intent(
                    this,
                    HomeActivity::class.java
                )

            // Success message

            Toast.makeText(
                this,
                "Registration Successful!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(intent)

        }

    }
}