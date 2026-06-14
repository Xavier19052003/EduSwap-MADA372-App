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

// ViewBinding import added
import com.example.eduswap.databinding.ActivityBookDetailsBinding

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

    // ViewBinding object
    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CONNECT VIEWS (using binding)

        // Main large book image
        val imgBookMain = binding.imgBookMain

        // Displays book title
        val tvBookTitle = binding.tvBookTitle

        // Displays book price
        val tvBookPrice = binding.tvBookPrice

        // Displays whether the book is New or Used
        val tvBookCondition = binding.tvBookCondition

        // Displays seller name
        val tvBookSeller = binding.tvBookSeller

        // Displays seller university/location
        val tvBookLocation = binding.tvBookLocation

        // Button used to start a chat inquiry
        val btnInquire = binding.button3

        // Thumbnail images below the main image
        val imgThumb1 = binding.imgThumb1
        val imgThumb2 = binding.imgThumb2
        val imgThumb3 = binding.imgThumb3

        val tvBookAuthor = binding.tvBookAuthor
        val tvBookEdition = binding.tvBookEdition
        val tvBookDescription = binding.tvBookDescription

        /*
            Checks whether the user opened:
            - the placeholder mock book
            OR
            - a real uploaded listing
        */

        if (BookData.selectedTextbook != null) {

            val textbook = BookData.selectedTextbook!!

            tvBookTitle.text = textbook.title
            tvBookPrice.text = "R${textbook.price}"
            tvBookSeller.text = textbook.seller
            tvBookLocation.text = textbook.university
            tvBookCondition.text = textbook.condition
            tvBookAuthor.text = "Author: ${textbook.author}"
            tvBookEdition.text = "Edition: ${textbook.edition}"
            tvBookDescription.text = textbook.description

            if (textbook.image1 != null) {
                imgBookMain.setImageURI(textbook.image1)
                imgThumb1.setImageURI(textbook.image1)
            }

            if (textbook.image2 != null) {
                imgThumb2.setImageURI(textbook.image2)
            }

            if (textbook.image3 != null) {
                imgThumb3.setImageURI(textbook.image3)
            }

            // THUMBNAIL CLICK EVENTS

            imgThumb1.setOnClickListener {
                if (textbook.image1 != null) {
                    imgBookMain.setImageURI(textbook.image1)
                }
            }

            imgThumb2.setOnClickListener {
                if (textbook.image2 != null) {
                    imgBookMain.setImageURI(textbook.image2)
                }
            }

            imgThumb3.setOnClickListener {
                if (textbook.image3 != null) {
                    imgBookMain.setImageURI(textbook.image3)
                }
            }

        } else {
            tvBookTitle.text = BookData.title
            tvBookPrice.text = "R${BookData.price}"
            tvBookSeller.text = BookData.seller
            tvBookLocation.text = BookData.university
            tvBookCondition.text = BookData.condition
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
                UserData.currentChatSeller = BookData.selectedTextbook!!.seller
            } else {
                UserData.currentChatSeller = BookData.seller
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

        // NAVBAR (using binding)
        val navHome = binding.navHome
        val navSell = binding.navSell
        val navAccount = binding.navAccount
        val navChat = binding.navChat

        // HOME BUTTON
        navHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        // SELL BUTTON
        navSell.setOnClickListener {
            startActivity(Intent(this, SellActivity::class.java))
        }

        // PROFILE BUTTON
        navAccount.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // CHAT BUTTON
        navChat.setOnClickListener {
            startActivity(Intent(this, ChatListActivity::class.java))
        }
    }
}