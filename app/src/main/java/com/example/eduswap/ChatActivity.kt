package com.example.eduswap

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat)

        // CHAT HEADER

        val tvChatSeller =
            findViewById<TextView>(
                R.id.tvChatSeller
            )

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

            // VALIDATION

            if (message.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter a message first",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            // CREATE MESSAGE

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

            messageText.setBackgroundColor(
                Color.parseColor("#D4EDDA")
            )

            val params =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

            params.topMargin = 16

            params.marginStart = 120

            messageText.layoutParams =
                params

            // ADD MESSAGE TO CHAT

            chatContainer.addView(
                messageText
            )

            // CLEAR INPUT

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

        navHome.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )

        }

        navSell.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    SellActivity::class.java
                )
            )

        }

        navAccount.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )

        }

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