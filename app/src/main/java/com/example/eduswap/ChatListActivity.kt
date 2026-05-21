package com.example.eduswap

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.TextView


class ChatListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat_list)

        val chatCard =
            findViewById<LinearLayout>(R.id.chatCard)

        val tvChatName =
            findViewById<TextView>(R.id.tvChatName)

        if (UserData.currentChatSeller.isNotEmpty()) {

            chatCard.visibility = View.VISIBLE

            tvChatName.text =
                UserData.currentChatSeller

        }

        chatCard.setOnClickListener {

            startActivity(
                Intent(this, ChatActivity::class.java)
            )

        }

        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navSell = findViewById<LinearLayout>(R.id.navSell)
        val navAccount = findViewById<LinearLayout>(R.id.navAccount)

        navHome.setOnClickListener {

            startActivity(Intent(this, HomeActivity::class.java))

        }

        navSell.setOnClickListener {

            startActivity(Intent(this, SellActivity::class.java))

        }

        navAccount.setOnClickListener {

            startActivity(Intent(this, ProfileActivity::class.java))

        }

    }
}