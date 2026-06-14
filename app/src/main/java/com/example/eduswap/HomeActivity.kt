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

// ViewBinding Import Added
import com.example.eduswap.databinding.ActivityHomeBinding

/*
    HomeActivity is the main marketplace screen.

    Users can:
    - View listed textbooks
    - Search for books
    - Open book details
    - Navigate to other screens
*/

class HomeActivity : AppCompatActivity() {

    //ViewBinding Object
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RECYCLERVIEW
        binding.rvBooks.layoutManager = LinearLayoutManager(this)

        val textbookAdapter = TextbookAdapter(TextbookRepository.textbooks)
        binding.rvBooks.adapter = textbookAdapter

        // SEARCH FUNCTION
        binding.etSearch.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val searchText = s.toString().lowercase()
                    val filteredBooks = TextbookRepository.textbooks.filter {
                        it.title.lowercase().contains(searchText)
                    }.toMutableList()
                    textbookAdapter.updateList(filteredBooks)
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
            }
        )

        // NAVBAR – SELL SCREEN
        binding.navSell.setOnClickListener {
            startActivity(Intent(this, SellActivity::class.java))
        }

        // NAVBAR – PROFILE SCREEN
        binding.navAccount.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // NAVBAR – CHAT SCREEN
        binding.navChat.setOnClickListener {
            startActivity(Intent(this, ChatListActivity::class.java))
        }
    }
}