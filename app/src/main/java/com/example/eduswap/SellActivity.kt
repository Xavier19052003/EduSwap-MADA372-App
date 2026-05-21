package com.example.eduswap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast


class SellActivity : AppCompatActivity() {

    // TRACK IMAGES

    private lateinit var imgBook1: ImageView
    private lateinit var imgBook2: ImageView
    private lateinit var imgBook3: ImageView

    private var currentImage = 1

    // IMAGE PICKER

    private val imagePicker =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri: Uri? ->

            if (uri != null) {

                when (currentImage) {

                    1 -> {

                        imgBook1.setImageURI(uri)

                        BookData.image1 = uri

                    }

                    2 -> {

                        imgBook2.setImageURI(uri)

                        BookData.image2 = uri

                    }

                    3 -> {

                        imgBook3.setImageURI(uri)

                        BookData.image3 = uri

                    }

                }

            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        // CHECKBOXES

        val cbNew =
            findViewById<CheckBox>(
                R.id.cbNew
            )

        val cbUsed =
            findViewById<CheckBox>(
                R.id.cbUsed
            )

        // ONLY ONE CHECKBOX ACTIVE

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

            // SAVE CONDITION

            if (cbNew.isChecked) {

                BookData.condition =
                    "New"

            }

            if (cbUsed.isChecked) {

                BookData.condition =
                    "Used"

            }

            Toast.makeText(
                this,
                "Book Listed Successfully!",
                Toast.LENGTH_SHORT
            ).show()

            // OPEN HOME SCREEN

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

        navHome.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )

        }

        navAccount.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ProfileActivity::class.java
                )
            )

        }

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