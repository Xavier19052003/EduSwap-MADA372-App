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

        // USER LISTING CARD

        val userMarketplaceCard =
            findViewById<LinearLayout>(
                R.id.userMarketplaceCard
            )

        val imgUserBook =
            findViewById<ImageView>(
                R.id.imgUserBook
            )

        val tvUserTitle =
            findViewById<TextView>(
                R.id.tvUserTitle
            )

        val tvUserPrice =
            findViewById<TextView>(
                R.id.tvUserPrice
            )

        val tvUserSeller =
            findViewById<TextView>(
                R.id.tvUserSeller
            )

        val tvUserUniversity =
            findViewById<TextView>(
                R.id.tvUserUniversity
            )

        // MOCK PLACEHOLDER CARD

        val marketplaceCard =
            findViewById<LinearLayout>(
                R.id.marketplaceCard
            )

        /*
            Displays the user listing
            only if a book has been posted
        */

        if (BookData.title.isNotEmpty()) {

            userMarketplaceCard.visibility =
                View.VISIBLE

            tvUserTitle.text =
                BookData.title

            tvUserPrice.text =
                "R${BookData.price}"

            tvUserSeller.text =
                "Seller: ${BookData.seller}"

            tvUserUniversity.text =
                "University: ${BookData.university}"

            // Loads uploaded image

            if (BookData.image1 != null) {

                imgUserBook.setImageURI(
                    BookData.image1
                )

            }

            // Opens user book details

            userMarketplaceCard.setOnClickListener {

                BookData.isMockBook = false

                startActivity(
                    Intent(
                        this,
                        BookDetailsActivity::class.java
                    )
                )

            }

        }

        // Opens mock book details

        marketplaceCard.setOnClickListener {

            BookData.isMockBook = true

            startActivity(
                Intent(
                    this,
                    BookDetailsActivity::class.java
                )
            )

        }

        // SEARCH FUNCTION

        etSearch.addTextChangedListener(
            object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {

                    val searchText =
                        s.toString().lowercase()

                    // MOCK BOOK SEARCH

                    val mockBookTitle =
                        "Lord of the Rings".lowercase()

                    if (
                        mockBookTitle.contains(searchText)
                    ) {

                        marketplaceCard.visibility =
                            View.VISIBLE

                    } else {

                        marketplaceCard.visibility =
                            View.GONE

                    }

                    // USER BOOK SEARCH

                    if (BookData.title.isNotEmpty()) {

                        if (
                            BookData.title.lowercase()
                                .contains(searchText)
                        ) {

                            userMarketplaceCard.visibility =
                                View.VISIBLE

                        } else {

                            userMarketplaceCard.visibility =
                                View.GONE

                        }

                    }

                    // SHOWS ALL BOOKS IF SEARCH IS EMPTY

                    if (searchText.isEmpty()) {

                        marketplaceCard.visibility =
                            View.VISIBLE

                        if (BookData.title.isNotEmpty()) {

                            userMarketplaceCard.visibility =
                                View.VISIBLE

                        }

                    }

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