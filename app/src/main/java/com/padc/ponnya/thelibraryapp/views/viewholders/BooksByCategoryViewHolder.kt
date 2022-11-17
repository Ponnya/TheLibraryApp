package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.adapters.EbooksAdapter
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBooksByCategoryBinding
import com.padc.ponnya.thelibraryapp.delegates.BooksByCategoryDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate

class BooksByCategoryViewHolder(
    private val mOptionMenuDelegate: OptionMenuAndDetailDelegate,
    private val delegate: BooksByCategoryDelegate,
    private val binding: ViewHolderBooksByCategoryBinding
) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var mEbooksAdapter: EbooksAdapter

    init {
        binding.btnSeeMore.setOnClickListener {
            delegate.onTapBtnMore()
        }
    }

    fun setNewData() {
        mEbooksAdapter = EbooksAdapter(mOptionMenuDelegate)
        binding.rvBooks.adapter = mEbooksAdapter
        binding.rvBooks.layoutManager = LinearLayoutManager(
            binding.root.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )


    }
}