package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBooksBinding
import com.padc.ponnya.thelibraryapp.views.viewholders.BooksViewHolder

class BooksAdapter : RecyclerView.Adapter<BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view =
            ViewHolderBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 4
}