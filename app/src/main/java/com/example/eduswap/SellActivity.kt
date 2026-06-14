package com.example.eduswap

// Allows navigation between screens
import android.content.Intent

// Used for storing selected gallery image paths
import android.net.Uri

// Used when the activity starts
import android.os.Bundle

// UI components used in this screen
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

// Allows users to select images from gallery
import androidx.activity.result.contract.ActivityResultContracts

// Base class for Android activities
import androidx.appcompat.app.AppCompatActivity

// Shows popup feedback messages
import android.widget.Toast

/*
    SellActivity allows users
    to create and upload
    a textbook listing.

    Users can:
    - Add book details
    - Upload images
    - Select condition
    - Post listing to marketplace
*/

class SellActivity : AppCompatActivity() {

    // IMAGE VIEWS

    private lateinit var imgBook1: ImageView
    private lateinit var imgBook2: ImageView
    private lateinit var imgBook3: ImageView

    // Tracks which image slot is selected

    private var currentImage = 1

    // IMAGE PICKER

    private val imagePicker =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->

            if (uri != null) {

                when (currentImage) {

                    // FIRST IMAGE

                    1 -> {

                        imgBook1.setImageURI(uri)

                        BookData.image1 = uri

                    }

                    // SECOND IMAGE

                    2 -> {

                        imgBook2.setImageURI(uri)

                        BookData.image2 = uri

                    }

                    // THIRD IMAGE

                    3 -> {

                        imgBook3.setImageURI(uri)

                        BookData.image3 = uri

                    }

                }

            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity
        // to activity_sell.xml
        setContentView(R.layout.activity_sell)

        // IMAGE VIEWS

        imgBook1 =
            findViewById(R.id.imgBook1)

        imgBook2 =
            findViewById(R.id.imgBook2)

        imgBook3 =
            findViewById(R.id.imgBook3)

        // IMAGE CLICK EVENTS

        imgBook1.setOnClickListener {

            currentImage = 1

            imagePicker.launch("image/*")

        }

        imgBook2.setOnClickListener {

            currentImage = 2

            imagePicker.launch("image/*")

        }

        imgBook3.setOnClickListener {

            currentImage = 3

            imagePicker.launch("image/*")

        }

        // FORM FIELDS

        val etBookTitle =
            findViewById<EditText>(
                R.id.etBookTitle
            )

        val etBookPrice =
            findViewById<EditText>(
                R.id.etBookPrice
            )
        val etAuthor =
            findViewById<EditText>(
                R.id.etAuthor
            )

        val etEdition =
            findViewById<EditText>(
                R.id.etEdition
            )

        val etDescription =
            findViewById<EditText>(
                R.id.etDescription
            )

        // CONDITION CHECKBOXES

        val cbNew =
            findViewById<CheckBox>(
                R.id.cbNew
            )

        val cbUsed =
            findViewById<CheckBox>(
                R.id.cbUsed
            )

        /*
            Allows only one condition
            to be selected at a time
        */

        cbNew.setOnClickListener {

            if (cbNew.isChecked) {

                cbUsed.isChecked = false

            }

        }

        cbUsed.setOnClickListener {

            if (cbUsed.isChecked) {

                cbNew.isChecked = false

            }

        }

        // LIST ITEM BUTTON

        val btnListItem =
            findViewById<Button>(
                R.id.btnListItem
            )

        btnListItem.setOnClickListener {

            val title =
                etBookTitle.text.toString()

            val price =
                etBookPrice.text.toString()

            val author =
                etAuthor.text.toString()

            val edition =
                etEdition.text.toString()

            val description =
                etDescription.text.toString()

            if (author.isEmpty()) {

                etAuthor.error =
                    "Enter the author"

                return@setOnClickListener

            }

            if (edition.isEmpty()) {

                etEdition.error =
                    "Enter the edition"

                return@setOnClickListener

            }

            if (description.isEmpty()) {

                etDescription.error =
                    "Enter a description"

                return@setOnClickListener

            }

            // VALIDATION

            if (title.isEmpty()) {

                etBookTitle.error =
                    "Enter a book title"

                return@setOnClickListener

            }

            if (price.isEmpty()) {

                etBookPrice.error =
                    "Enter a price"

                return@setOnClickListener

            }

            // Checks if condition was selected

            if (!cbNew.isChecked &&
                !cbUsed.isChecked
            ) {

                cbUsed.error =
                    "Select a condition"

                return@setOnClickListener

            }

            // SAVE BOOK DATA

            BookData.university =
                UserData.university

            BookData.title =
                title

            BookData.price =
                price

            BookData.seller =
                UserData.name

            // SAVE BOOK CONDITION

            if (cbNew.isChecked) {

                BookData.condition =
                    "New"

            }

            if (cbUsed.isChecked) {

                BookData.condition =
                    "Used"

            }

            // CREATE NEW TEXTBOOK OBJECT

            val textbook =
                Textbook(
                    title = title,
                    author = author,
                    edition = edition,
                    description = description,
                    price = price,
                    seller = UserData.name,
                    university = UserData.university,
                    condition = BookData.condition,
                    image1 = BookData.image1,
                    image2 = BookData.image2,
                    image3 = BookData.image3
                )

            // ADD TO REPOSITORY

            TextbookRepository.textbooks.add(
                textbook
            )

            // Success message

            Toast.makeText(
                this,
                "Book Listed Successfully!",
                Toast.LENGTH_SHORT
            ).show()

            // Opens home screen

            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )

        }

        // NAVBAR

        val navHome =
            findViewById<LinearLayout>(
                R.id.navHome
            )

        val navAccount =
            findViewById<LinearLayout>(
                R.id.navAccount
            )

        val navChat =
            findViewById<LinearLayout>(
                R.id.navChat
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