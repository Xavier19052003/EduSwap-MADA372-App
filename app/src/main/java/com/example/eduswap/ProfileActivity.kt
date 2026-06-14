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

// ViewBinding import added
import com.example.eduswap.databinding.ActivityProfileBinding

/*
    ProfileActivity displays
    the user's personal information
    and their listed textbook.
*/

class ProfileActivity : AppCompatActivity() {

    // ViewBinding object
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // PROFILE LISTING VIEWS (using binding)
        val imgProfileBook = binding.imgProfileBook
        val tvProfileBookTitle = binding.tvProfileBookTitle
        val tvProfileBookPrice = binding.tvProfileBookPrice
        val profileListingCard = binding.profileListingCard
        val tvNoListings = binding.tvNoListings

        /*
            Shows the user's listing
            only if a book has been posted
        */
        if (BookData.title.isNotEmpty()) {
            tvProfileBookTitle.text = BookData.title
            tvProfileBookPrice.text = "R${BookData.price}"

            // Loads uploaded image
            if (BookData.image1 != null) {
                imgProfileBook.setImageURI(BookData.image1)
            }

            profileListingCard.visibility = View.VISIBLE
            tvNoListings.visibility = View.GONE
        }

        // PROFILE FIELDS (using binding)
        val etName = binding.etName
        val etEmail = binding.etEmail
        val etUniversity = binding.etUniversity

        // Loads saved user data
        etName.setText(UserData.name)
        etEmail.setText(UserData.email)
        etUniversity.setText(UserData.university)

        // NAVBAR (using binding)
        val navHome = binding.navHome
        val navSell = binding.navSell
        val navChat = binding.navChat

        // BUTTONS (using binding)
        val btnLogout = binding.button4
        val btnRemoveListing = binding.btnRemoveListing

        // HOME SCREEN
        navHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        // SELL SCREEN
        navSell.setOnClickListener {
            startActivity(Intent(this, SellActivity::class.java))
        }

        // CHAT SCREEN
        navChat.setOnClickListener {
            startActivity(Intent(this, ChatListActivity::class.java))
        }

        // REMOVE LISTING
        btnRemoveListing.setOnClickListener {
            TextbookRepository.textbooks.removeIf {
                it.seller == UserData.name
            }

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
            profileListingCard.visibility = View.GONE
            tvNoListings.visibility = View.VISIBLE

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
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}