package com.example.eduswap

// Allows movement between app screens
import android.content.Intent

// Used for message bubble colours
import android.graphics.Color

// Used when the activity starts
import android.os.Bundle

// UI components used in this screen
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

// Shows popup feedback messages
import android.widget.Toast

// Base class for app screens
import androidx.appcompat.app.AppCompatActivity

/*
    ChatActivity allows users
    to send simple inquiry messages
    to textbook sellers.
*/

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity
        // to activity_chat.xml
        setContentView(R.layout.activity_chat)

        // CHAT HEADER

        val tvChatSeller =
            findViewById<TextView>(
                R.id.tvChatSeller
            )

        // Displays seller name
        tvChatSeller.text =
            UserData.currentChatSeller

        // CHAT INPUT

        val etMessage =
            findViewById<EditText>(
                R.id.etMessage
            )

        val btnSend =
            findViewById<Button>(
                R.id.btnSend
            )

        val chatContainer =
            findViewById<LinearLayout>(
                R.id.chatContainer
            )

        // SEND MESSAGE

        btnSend.setOnClickListener {

            val message =
                etMessage.text.toString()

            // Prevents empty messages

            if (message.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter a message first",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            // Creates a new message bubble

            val messageText =
                TextView(this)

            messageText.text =
                message

            messageText.textSize = 16f

            messageText.setPadding(
                24,
                16,
                24,
                16
            )

            // Message bubble colour

            messageText.setBackgroundColor(
                Color.parseColor("#D4EDDA")
            )

            // Positions message on screen

            val params =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

            params.topMargin = 16

            params.marginStart = 120

            messageText.layoutParams =
                params

            // Adds message to chat

            chatContainer.addView(
                messageText
            )

            // Clears text input

            etMessage.text.clear()

        }

        // NAVBAR

        val navHome =
            findViewById<LinearLayout>(
                R.id.navHome
            )

        val navSell =
            findViewById<LinearLayout>(
                R.id.navSell
            )

        val navAccount =
            findViewById<LinearLayout>(
                R.id.navAccount
            )

        val navChat =
            findViewById<LinearLayout>(
                R.id.navChat
            )

        // HOME SCREEN

        navHome.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )

        }

        // SELL SCREEN

        navSell.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    SellActivity::class.java
                )
            )

        }

        // PROFILE SCREEN

        navAccount.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )

        }

        // CHAT LIST SCREEN

        navChat.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ChatListActivity::class.java
                )
            )

        }

    }
}