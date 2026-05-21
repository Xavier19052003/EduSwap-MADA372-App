package com.example.eduswap

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        // SEARCH BAR

        val etSearch =
            findViewById<EditText>(R.id.etSearch)

        // USER CARD

        val userMarketplaceCard =
            findViewById<LinearLayout>(R.id.userMarketplaceCard)

        val imgUserBook =
            findViewById<ImageView>(R.id.imgUserBook)

        val tvUserTitle =
            findViewById<TextView>(R.id.tvUserTitle)

        val tvUserPrice =
            findViewById<TextView>(R.id.tvUserPrice)

        val tvUserSeller =
            findViewById<TextView>(R.id.tvUserSeller)

        val tvUserUniversity =
            findViewById<TextView>(R.id.tvUserUniversity)

        // MOCK CARD

        val marketplaceCard =
            findViewById<LinearLayout>(R.id.marketplaceCard)

        // USER BOOK DATA

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

            if (BookData.image1 != null) {

                imgUserBook.setImageURI(
                    BookData.image1
                )

            }

            // USER CARD CLICK

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

        // MOCK CARD CLICK

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

                    // MOCK BOOK

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

                    // USER BOOK

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

                    // EMPTY SEARCH

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
            findViewById<LinearLayout>(R.id.navSell)

        val navAccount =
            findViewById<LinearLayout>(R.id.navAccount)

        val navChat =
            findViewById<LinearLayout>(R.id.navChat)

        navSell.setOnClickListener {

            startActivity(
                Intent(this, SellActivity::class.java)
            )

        }

        navAccount.setOnClickListener {

            startActivity(
                Intent(this, ProfileActivity::class.java)
            )

        }

        navChat.setOnClickListener {

            startActivity(
                Intent(this, ChatListActivity::class.java)
            )

        }

    }
}