package com.example.eduswap

// Allows navigation between screens
import android.content.Intent

// Used when the activity starts
import android.os.Bundle

// Used to show or hide views
import android.view.View

// UI components used in this screen
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

// Shows popup feedback messages
import android.widget.Toast

// Base class for Android activities
import androidx.appcompat.app.AppCompatActivity

/*
    ProfileActivity displays
    the user's personal information
    and their listed textbook.
*/

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity
        // to activity_profile.xml
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

        /*
            Shows the user's listing
            only if a book has been posted
        */

        if (BookData.title.isNotEmpty()) {

            tvProfileBookTitle.text =
                BookData.title

            tvProfileBookPrice.text =
                "R${BookData.price}"

            // Loads uploaded image

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
            findViewById<EditText>(
                R.id.etName
            )

        val etEmail =
            findViewById<EditText>(
                R.id.etEmail
            )

        val etUniversity =
            findViewById<EditText>(
                R.id.etUniversity
            )

        // Loads saved user data

        etName.setText(UserData.name)

        etEmail.setText(UserData.email)

        etUniversity.setText(UserData.university)

        // NAVBAR

        val navHome =
            findViewById<LinearLayout>(
                R.id.navHome
            )

        val navSell =
            findViewById<LinearLayout>(
                R.id.navSell
            )

        val navChat =
            findViewById<LinearLayout>(
                R.id.navChat
            )

        // BUTTONS

        val btnLogout =
            findViewById<Button>(
                R.id.button4
            )

        val btnRemoveListing =
            findViewById<Button>(
                R.id.btnRemoveListing
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

        // CHAT SCREEN

        navChat.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ChatListActivity::class.java
                )
            )

        }

        // REMOVE LISTING

        btnRemoveListing.setOnClickListener {

            // Clears stored book data

            BookData.title = ""
            BookData.price = ""
            BookData.seller = ""
            BookData.university = ""
            BookData.condition = ""

            BookData.image1 = null
            BookData.image2 = null
            BookData.image3 = null

            // Hides listing card

            profileListingCard.visibility =
                View.GONE

            tvNoListings.visibility =
                View.VISIBLE

            // Success message

            Toast.makeText(
                this,
                "Listing removed successfully!",
                Toast.LENGTH_SHORT
            ).show()

        }

        // LOGOUT

        btnLogout.setOnClickListener {

            // Clears user data

            UserData.name = ""
            UserData.email = ""
            UserData.university = ""

            // Clears book data

            BookData.title = ""
            BookData.price = ""
            BookData.seller = ""
            BookData.university = ""
            BookData.condition = ""

            BookData.image1 = null
            BookData.image2 = null
            BookData.image3 = null

            // Logout message

            Toast.makeText(
                this,
                "Logout Successful!",
                Toast.LENGTH_SHORT
            ).show()

            // Returns to register screen

            val intent =
                Intent(
                    this,
                    RegisterActivity::class.java
                )

            startActivity(intent)

            finish()

        }

    }
}