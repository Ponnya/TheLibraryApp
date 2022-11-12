package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderMoreEbooksBinding
import com.padc.ponnya.thelibraryapp.views.viewholders.MoreEbooksViewHolder

class MoreEbooksAdapter : RecyclerView.Adapter<MoreEbooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreEbooksViewHolder {
        val view =
            ViewHolderMoreEbooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoreEbooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreEbooksViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 6
}