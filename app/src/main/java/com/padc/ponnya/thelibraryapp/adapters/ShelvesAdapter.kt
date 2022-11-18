package com.padc.ponnya.thelibraryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderShelvesBinding
import com.padc.ponnya.thelibraryapp.delegates.ShelvesDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.ShelvesViewHolder

class ShelvesAdapter(private val delegate: ShelvesDelegate) :
    RecyclerView.Adapter<ShelvesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesViewHolder {
        val view =
            ViewHolderShelvesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShelvesViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: ShelvesViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 15
}