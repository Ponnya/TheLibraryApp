package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderSearchBookBinding
import com.padc.ponnya.thelibraryapp.views.viewholders.SearchBookViewHolder

class SearchBookAdapter : RecyclerView.Adapter<SearchBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        val view =
            ViewHolderSearchBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 15
}