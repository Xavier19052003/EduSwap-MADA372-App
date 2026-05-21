package com.example.eduswap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        // PROFILE LISTING VIEWS

        val imgProfileBook =
            findViewById<ImageView>(
                R.id.imgProfileBook
            )

        val tvProfileBookTitle =
            findViewById<TextView>(
                R.id.tvProfileBookTitle
            )

        val tvProfileBookPrice =
            findViewById<TextView>(
                R.id.tvProfileBookPrice
            )

        val profileListingCard =
            findViewById<LinearLayout>(
                R.id.profileListingCard
            )

        val tvNoListings =
            findViewById<TextView>(
                R.id.tvNoListings
            )

        // SHOW LISTING ONLY IF USER POSTED A BOOK

        if (BookData.title.isNotEmpty()) {

            tvProfileBookTitle.text =
                BookData.title

            tvProfileBookPrice.text =
                "R${BookData.price}"

            if (BookData.image1 != null) {

                imgProfileBook.setImageURI(
                    BookData.image1
                )

            }

            profileListingCard.visibility =
                View.VISIBLE

            tvNoListings.visibility =
                View.GONE

        }

        // PROFILE FIELDS

        val etName =
            findViewById<EditText>(R.id.etName)

        val etEmail =
            findViewById<EditText>(R.id.etEmail)

        val etUniversity =
            findViewById<EditText>(R.id.etUniversity)

        // LOAD USER DATA

        etName.setText(UserData.name)

        etEmail.setText(UserData.email)

        etUniversity.setText(UserData.university)

        // NAVBAR

        val navHome =
            findViewById<LinearLayout>(R.id.navHome)

        val navSell =
            findViewById<LinearLayout>(R.id.navSell)

        val navChat =
            findViewById<LinearLayout>(R.id.navChat)

        // LOGOUT BUTTON

        val btnLogout =
            findViewById<Button>(R.id.button4)

        // NAVIGATION

        navHome.setOnClickListener {

            startActivity(
                Intent(this, HomeActivity::class.java)
            )

        }

        navSell.setOnClickListener {

            startActivity(
                Intent(this, SellActivity::class.java)
            )

        }

        navChat.setOnClickListener {

            startActivity(
                Intent(this, ChatListActivity::class.java)
            )

        }

        // LOGOUT

        btnLogout.setOnClickListener {

            // CLEAR TEMPORARY DATA

            UserData.name = ""
            UserData.email = ""
            UserData.university = ""

            BookData.title = ""
            BookData.price = ""
            BookData.seller = ""
            BookData.university = ""

            BookData.image1 = null
            BookData.image2 = null
            BookData.image3 = null

            // RETURN TO REGISTER

            val intent =
                Intent(
                    this,
                    RegisterActivity::class.java
                )

            Toast.makeText(
                this,
                "Logout Successful!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(intent)

            finish()

        }

    }
}