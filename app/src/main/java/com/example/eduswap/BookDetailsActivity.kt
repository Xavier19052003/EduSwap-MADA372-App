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

        if (BookData.isMockBook) {

            // MOCK BOOK DATA

            tvBookTitle.text =
                "Lord of the Rings"

            tvBookPrice.text =
                "R200"

            tvBookSeller.text =
                "Durell"

            tvBookLocation.text =
                "STADIO University"

            tvBookCondition.text =
                "Used"

        } else {

            // USER BOOK DATA

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

            // LOAD MAIN IMAGE

            if (BookData.image1 != null) {

                imgBookMain.setImageURI(
                    BookData.image1
                )

                imgThumb1.setImageURI(
                    BookData.image1
                )

            }

            // LOAD SECOND IMAGE

            if (BookData.image2 != null) {

                imgThumb2.setImageURI(
                    BookData.image2
                )

            }

            // LOAD THIRD IMAGE

            if (BookData.image3 != null) {

                imgThumb3.setImageURI(
                    BookData.image3
                )

            }

            /*
                Allows the user to switch
                the main image by clicking
                the thumbnails
            */

            imgThumb1.setOnClickListener {

                if (BookData.image1 != null) {

                    imgBookMain.setImageURI(
                        BookData.image1
                    )

                }

            }

            imgThumb2.setOnClickListener {

                if (BookData.image2 != null) {

                    imgBookMain.setImageURI(
                        BookData.image2
                    )

                }

            }

            imgThumb3.setOnClickListener {

                if (BookData.image3 != null) {

                    imgBookMain.setImageURI(
                        BookData.image3
                    )

                }

            }

        }

        // INQUIRE BUTTON

        btnInquire.setOnClickListener {

            /*
                Prevents the user from
                messaging themselves
            */

            if (BookData.seller == UserData.name) {

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

            if (BookData.isMockBook) {

                UserData.currentChatSeller =
                    "Durell"

            } else {

                UserData.currentChatSeller =
                    BookData.seller

            }

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