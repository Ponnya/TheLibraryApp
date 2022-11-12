package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderEbooksBinding
import com.padc.ponnya.thelibraryapp.views.viewholders.EbooksViewHolder

class EbooksAdapter : RecyclerView.Adapter<EbooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbooksViewHolder {
        val view =
            ViewHolderEbooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EbooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: EbooksViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 4
}