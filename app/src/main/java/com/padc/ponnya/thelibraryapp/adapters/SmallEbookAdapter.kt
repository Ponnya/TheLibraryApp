package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderSmallEbookBinding
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.SmallEbookViewHolder

class SmallEbookAdapter(private val delegate: OptionMenuDelegate) :
    RecyclerView.Adapter<SmallEbookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallEbookViewHolder {
        val view =
            ViewHolderSmallEbookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmallEbookViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: SmallEbookViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 6
}