package com.example.eduswap

object TextbookRepository {

    val textbooks =
        mutableListOf<Textbook>()

    init {

        textbooks.add(

            Textbook(

                title = "The Hobbit",

                price = "200",

                seller = "Kaitlynn",

                university = "STADIO",

                condition = "Used"

            )

        )

    }

}