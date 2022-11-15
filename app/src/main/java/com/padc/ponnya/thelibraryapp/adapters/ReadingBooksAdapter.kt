package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderReadingBooksBinding
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.ReadingBooksViewHolder

class ReadingBooksAdapter(private val delegate: CarouselOptionMenuDelegate) :
    RecyclerView.Adapter<ReadingBooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadingBooksViewHolder {
        val view = ViewHolderReadingBooksBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReadingBooksViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: ReadingBooksViewHolder, position: Int) {


    }

    override fun getItemCount(): Int = 4
}