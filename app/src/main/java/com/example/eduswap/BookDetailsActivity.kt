package com.example.eduswap

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_book_details)

        // CONNECT VIEWS

        val imgBookMain =
            findViewById<ImageView>(R.id.imgBookMain)

        val tvBookTitle =
            findViewById<TextView>(R.id.tvBookTitle)

        val tvBookPrice =
            findViewById<TextView>(R.id.tvBookPrice)

        val tvBookCondition =
            findViewById<TextView>(
                R.id.tvBookCondition
            )

        val tvBookSeller =
            findViewById<TextView>(R.id.tvBookSeller)

        val tvBookLocation =
            findViewById<TextView>(R.id.tvBookLocation)

        val btnInquire =
            findViewById<Button>(R.id.button3)

        val imgThumb1 =
            findViewById<ImageView>(R.id.imgThumb1)

        val imgThumb2 =
            findViewById<ImageView>(R.id.imgThumb2)

        val imgThumb3 =
            findViewById<ImageView>(R.id.imgThumb3)

        // CHECK WHICH BOOK WAS CLICKED

        if (BookData.isMockBook) {

            // MOCK BOOK

            tvBookTitle.text = "Lord of the Rings"

            tvBookPrice.text = "R200"

            tvBookSeller.text = "Durell"

            tvBookLocation.text = "STADIO University"

        } else {

            // USER BOOK

            tvBookTitle.text =
                BookData.title

            tvBookPrice.text =
                "R${BookData.price}"

            tvBookSeller.text =
                BookData.seller

            tvBookLocation.text =
                BookData.university

            // MAIN IMAGE

            if (BookData.image1 != null) {

                tvBookCondition.text = "Used"

                imgBookMain.setImageURI(
                    BookData.image1
                )

                imgThumb1.setImageURI(
                    BookData.image1
                )

            }

            // SECOND IMAGE

            if (BookData.image2 != null) {

                imgThumb2.setImageURI(
                    BookData.image2
                )

            }

            // THIRD IMAGE

            if (BookData.image3 != null) {

                imgThumb3.setImageURI(
                    BookData.image3
                )

            }

            // THUMBNAIL CLICK EVENTS

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
        btnInquire.setOnClickListener {

            if (BookData.isMockBook) {

                UserData.currentChatSeller = "Durell"

            } else {

                tvBookCondition.text =
                    BookData.condition

                tvBookLocation.text =
                    BookData.university

                UserData.currentChatSeller =
                    BookData.seller

            }

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