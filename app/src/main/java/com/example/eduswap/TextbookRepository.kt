package com.example.eduswap

object TextbookRepository {

    val textbooks =
        mutableListOf(

            Textbook(
                title = "The Hobbit",
                author = "J.R.R. Tolkien",
                edition = "3rd Edition",
                description = "Fantasy adventure novel.",
                price = "200",
                seller = "Durell",
                university = "STADIO",
                condition = "Used"
            ),

            Textbook(
                title = "Database Systems",
                author = "Thomas Connolly",
                edition = "6th Edition",
                description = "Introduction to database design and SQL.",
                price = "350",
                seller = "Sarah",
                university = "STADIO",
                condition = "Used"
            ),

            Textbook(
                title = "Java Programming",
                author = "John Lewis",
                edition = "8th Edition",
                description = "Comprehensive Java programming textbook.",
                price = "420",
                seller = "Mike",
                university = "Varsity College",
                condition = "New"
            ),

            Textbook(
                title = "Information Systems",
                author = "Ralph Stair",
                edition = "10th Edition",
                description = "Fundamentals of information systems.",
                price = "300",
                seller = "Emma",
                university = "IIE MSA",
                condition = "Used"
            )

        )

}