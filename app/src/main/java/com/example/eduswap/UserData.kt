package com.example.eduswap

/*
    UserData temporarily stores
    information related to the user
    while the app is running.

    This data is shared between
    different activities in the app.
*/

object UserData {

    // Stores the user's name
    var name = ""

    // Stores the user's email
    var email = ""

    // Stores the user's university
    var university = ""

    /*
        Stores the seller name
        of the currently opened chat.

        Used when navigating
        between BookDetailsActivity,
        ChatListActivity,
        and ChatActivity.
    */
    var currentChatSeller = ""

}