package com.example.eduswap

// Used for storing selected image paths
// from the device gallery
import android.net.Uri

/*
    BookData temporarily stores
    all textbook listing information
    while the app is running.

    This object is shared across
    multiple activities such as:
    - HomeActivity
    - SellActivity
    - BookDetailsActivity
    - ProfileActivity

    Since this MVP does not use
    a database yet, all data is
    stored temporarily in memory.
*/

object BookData {

    // Stores the textbook title
    var title = ""

    // Stores the textbook price
    var price = ""

    // Stores the seller name
    var seller = ""

    // Stores the seller's university
    var university = ""

    /*
        Stores up to 3 uploaded
        textbook images.

        Uri is used because the
        images are selected from
        the device gallery.
    */

    var image1: Uri? = null
    var image2: Uri? = null
    var image3: Uri? = null

    /*
        Determines whether the user
        opened the mock placeholder book
        or a real uploaded listing.

        true  = mock book
        false = user uploaded book
    */

    var isMockBook = false

    // Stores the textbook condition:
    // "New" or "Used"

    var condition = ""

    var selectedTextbook: Textbook? = null

    var author = ""

    var edition = ""

    var description = ""

}