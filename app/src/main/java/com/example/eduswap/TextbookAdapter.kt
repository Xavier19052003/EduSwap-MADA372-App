package com.example.eduswap

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class TextbookAdapter(

    private val textbooks: List<Textbook>

) : RecyclerView.Adapter<TextbookAdapter.TextbookViewHolder>() {

    class TextbookViewHolder(

        itemView: View

    ) : RecyclerView.ViewHolder(itemView) {

        val imgBook =
            itemView.findViewById<ImageView>(
                R.id.imgBook
            )

        val tvTitle =
            itemView.findViewById<TextView>(
                R.id.tvTitle
            )

        val tvPrice =
            itemView.findViewById<TextView>(
                R.id.tvPrice
            )

        val tvSeller =
            itemView.findViewById<TextView>(
                R.id.tvSeller
            )

        val tvUniversity =
            itemView.findViewById<TextView>(
                R.id.tvUniversity
            )

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TextbookViewHolder {

        val view =
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_book,
                parent,
                false
            )

        return TextbookViewHolder(view)

    }

    override fun getItemCount(): Int {

        return textbooks.size

    }

    override fun onBindViewHolder(
        holder: TextbookViewHolder,
        position: Int
    ) {

        val textbook =
            textbooks[position]

        holder.tvTitle.text =
            textbook.title

        holder.tvPrice.text =
            "R${textbook.price}"

        holder.tvSeller.text =
            "Seller: ${textbook.seller}"

        holder.tvUniversity.text =
            "University: ${textbook.university}"

        if (textbook.image1 != null) {

            holder.imgBook.setImageURI(
                textbook.image1
            )

        }
        holder.itemView.setOnClickListener {

            BookData.selectedTextbook =
                textbook

            val intent =
                Intent(
                    holder.itemView.context,
                    BookDetailsActivity::class.java
                )

            holder.itemView.context.startActivity(
                intent
            )

        }

    }

}