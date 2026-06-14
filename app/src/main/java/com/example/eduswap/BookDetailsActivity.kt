package com.example.eduswap

// Allows navigation between screens/activities
import android.content.Intent

// Used to start the activity and save screen state
import android.os.Bundle

// UI components used in this screen
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button

// Shows small popup feedback messages
import android.widget.Toast

// Base class for Android app screens
import androidx.appcompat.app.AppCompatActivity

/*
    BookDetailsActivity displays all information
    about the selected textbook listing.

    This includes:
    - Book title
    - Price
    - Seller
    - University
    - Book condition
    - Uploaded images

    The screen also allows the user
    to start a chat inquiry with the seller.
*/

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this Kotlin file
        // to activity_book_details.xml
        setContentView(R.layout.activity_book_details)

        // CONNECT VIEWS

        // Main large book image
        val imgBookMain =
            findViewById<ImageView>(R.id.imgBookMain)

        // Displays book title
        val tvBookTitle =
            findViewById<TextView>(R.id.tvBookTitle)

        // Displays book price
        val tvBookPrice =
            findViewById<TextView>(R.id.tvBookPrice)

        // Displays whether the book is New or Used
        val tvBookCondition =
            findViewById<TextView>(
                R.id.tvBookCondition
            )

        // Displays seller name
        val tvBookSeller =
            findViewById<TextView>(R.id.tvBookSeller)

        // Displays seller university/location
        val tvBookLocation =
            findViewById<TextView>(R.id.tvBookLocation)

        // Button used to start a chat inquiry
        val btnInquire =
            findViewById<Button>(R.id.button3)

        // Thumbnail images below the main image
        val imgThumb1 =
            findViewById<ImageView>(R.id.imgThumb1)

        val imgThumb2 =
            findViewById<ImageView>(R.id.imgThumb2)

        val imgThumb3 =
            findViewById<ImageView>(R.id.imgThumb3)

        /*
            Checks whether the user opened:
            - the placeholder mock book
            OR
            - a real uploaded listing
        */

        if (BookData.selectedTextbook != null) {

            val textbook =
                BookData.selectedTextbook!!

            tvBookTitle.text =
                textbook.title

            tvBookPrice.text =
                "R${textbook.price}"

            tvBookSeller.text =
                textbook.seller

            tvBookLocation.text =
                textbook.university

            tvBookCondition.text =
                textbook.condition

            if (textbook.image1 != null) {

                imgBookMain.setImageURI(
                    textbook.image1
                )

                imgThumb1.setImageURI(
                    textbook.image1
                )

            }

        } else {

            tvBookTitle.text =
                BookData.title

            tvBookPrice.text =
                "R${BookData.price}"

            tvBookSeller.text =
                BookData.seller

            tvBookLocation.text =
                BookData.university

            tvBookCondition.text =
                BookData.condition

        }

        // INQUIRE BUTTON

        btnInquire.setOnClickListener {

            /*
                Prevents the user from
                messaging themselves
            */

            if (
                BookData.selectedTextbook != null &&
                BookData.selectedTextbook!!.seller == UserData.name
            ) {

                Toast.makeText(
                    this,
                    "You cannot inquire on your own listing",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener

            }

            /*
                Stores the seller name
                so the chat screen knows
                who the conversation is with
            */

            if (BookData.selectedTextbook != null) {

                UserData.currentChatSeller =
                    BookData.selectedTextbook!!.seller

            } else {

                UserData.currentChatSeller =
                    BookData.seller

            }
            Toast.makeText(
                this,
                "Seller = ${UserData.currentChatSeller}",
                Toast.LENGTH_LONG
            ).show()
            // Opens the chat screen

            startActivity(
                Intent(this, ChatActivity::class.java)
            )

        }

        // NAVBAR

        val navHome =
            findViewById<LinearLayout>(R.id.navHome)

        val navSell =
            findViewById<LinearLayout>(R.id.navSell)

        val navAccount =
            findViewById<LinearLayout>(R.id.navAccount)

        val navChat =
            findViewById<LinearLayout>(R.id.navChat)

        // HOME BUTTON

        navHome.setOnClickListener {

            startActivity(
                Intent(this, HomeActivity::class.java)
            )

        }

        // SELL BUTTON

        navSell.setOnClickListener {

            startActivity(
                Intent(this, SellActivity::class.java)
            )

        }

        // PROFILE BUTTON

        navAccount.setOnClickListener {

            startActivity(
                Intent(this, ProfileActivity::class.java)
            )

        }

        // CHAT BUTTON

        navChat.setOnClickListener {

            startActivity(
                Intent(this, ChatListActivity::class.java)
            )

        }

    }
}