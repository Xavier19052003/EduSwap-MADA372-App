package com.example.eduswap

// Allows navigation between screens
import android.content.Intent

// Used when the activity starts
import android.os.Bundle

// Used to show or hide views
import android.view.View

// UI components used in this screen
import android.widget.LinearLayout
import android.widget.TextView

// Base class for Android activities
import androidx.appcompat.app.AppCompatActivity

/*
    ChatListActivity displays
    the user's active chats.

    A chat only appears once
    the user has inquired
    about a textbook listing.
*/

class ChatListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity
        // to activity_chat_list.xml
        setContentView(R.layout.activity_chat_list)

        // CHAT CARD

        val chatCard =
            findViewById<LinearLayout>(
                R.id.chatCard
            )

        val tvChatName =
            findViewById<TextView>(
                R.id.tvChatName
            )

        /*
            Shows the chat card only
            if a conversation exists
        */

        if (UserData.currentChatSeller.isNotEmpty()) {

            chatCard.visibility =
                View.VISIBLE

            // Displays seller name

            tvChatName.text =
                UserData.currentChatSeller

        }

        // Opens the selected chat

        chatCard.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ChatActivity::class.java
                )
            )

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

    }
}