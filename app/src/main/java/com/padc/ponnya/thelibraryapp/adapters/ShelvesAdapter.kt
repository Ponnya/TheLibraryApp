package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderShelvesBinding
import com.padc.ponnya.thelibraryapp.delegates.ShelvesDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.ShelvesViewHolder

class ShelvesAdapter(private val delegate: ShelvesDelegate) :
    RecyclerView.Adapter<ShelvesViewHolder>() {

    private var mShelves: List<ShelfVO> = listOf()
    private var mShelvesScreenType: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesViewHolder {
        val view =
            ViewHolderShelvesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShelvesViewHolder(delegate, view)
    }

    override fun onBindViewHolder(holder: ShelvesViewHolder, position: Int) {
        if (mShelves.isNotEmpty()) {
            holder.bindData(mShelves[position], mShelvesScreenType)
        }
    }

    override fun getItemCount(): Int = mShelves.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(shelves: List<ShelfVO>, shelvesScreenType: String) {
        mShelvesScreenType = shelvesScreenType
        mShelves = shelves
        notifyDataSetChanged()
    }
}