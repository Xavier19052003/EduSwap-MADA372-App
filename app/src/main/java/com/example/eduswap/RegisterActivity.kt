package com.example.eduswap

// Allows navigation between screens
import android.content.Intent

// Used when the activity starts
import android.os.Bundle

// Shows popup feedback messages
import android.widget.Toast

// Base class for Android activities
import androidx.appcompat.app.AppCompatActivity

// ViewBinding for activity_register.xml
import com.example.eduswap.databinding.ActivityRegisterBinding

/*
    RegisterActivity allows the user
    to create a simple profile before
    entering the app.

    The user's:
    - name
    - email
    - university

    are temporarily stored in UserData.

    ViewBinding is used instead of
    findViewById() to connect UI
    components to Kotlin code.
*/

class RegisterActivity : AppCompatActivity() {

    // ViewBinding object

    private lateinit var binding:
            ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflates activity_register.xml

        binding =
            ActivityRegisterBinding.inflate(
                layoutInflater
            )

        // Displays the layout

        setContentView(
            binding.root
        )

        // REGISTER BUTTON

        binding.btnRegister.setOnClickListener {

            // Gets entered text

            val name =
                binding.etName.text.toString()

            val email =
                binding.etEmail.text.toString()

            val university =
                binding.etUniversity.text.toString()

            // VALIDATION

            if (name.isEmpty()) {

                binding.etName.error =
                    "Enter your name"

                return@setOnClickListener

            }

            if (email.isEmpty()) {

                binding.etEmail.error =
                    "Enter your email"

                return@setOnClickListener

            }

            if (university.isEmpty()) {

                binding.etUniversity.error =
                    "Enter your university"

                return@setOnClickListener

            }

            // SAVE USER DATA

            UserData.name =
                name

            UserData.email =
                email

            UserData.university =
                university

            // Success message

            Toast.makeText(
                this,
                "Registration Successful!",
                Toast.LENGTH_SHORT
            ).show()

            // Opens Home screen

            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )

        }

    }

}