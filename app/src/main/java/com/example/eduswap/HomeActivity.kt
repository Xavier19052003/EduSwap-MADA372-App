package com.example.eduswap

// Allows movement between app screens
import android.content.Intent

// Used when the activity starts
import android.os.Bundle

// Used for search bar text changes
import android.text.Editable
import android.text.TextWatcher

// Used to show or hide views
import android.view.View

// UI components used in this screen
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

// Base class for Android activities
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
    HomeActivity is the main marketplace screen.

    Users can:
    - View listed textbooks
    - Search for books
    - Open book details
    - Navigate to other screens
*/

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity
        // to activity_home.xml
        setContentView(R.layout.activity_home)

        // SEARCH BAR

        val etSearch =
            findViewById<EditText>(R.id.etSearch)

        // RECYCLERVIEW

        val rvBooks =
            findViewById<RecyclerView>(
                R.id.rvBooks
            )

        rvBooks.layoutManager =
            LinearLayoutManager(this)

        rvBooks.adapter =
            TextbookAdapter(
                TextbookRepository.textbooks
            )

        // SEARCH FUNCTION

        etSearch.addTextChangedListener(
            object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {

                    val searchText =
                        s.toString().lowercase()

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                }

            })

        // NAVBAR

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

        // CHAT SCREEN

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