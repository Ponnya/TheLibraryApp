package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.adapters.BooksAdapter
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBooksByCategoryBinding

class BooksByCategoryViewHolder(private val binding: ViewHolderBooksByCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val mBooksAdapter = BooksAdapter()
    fun setNewData() {
        binding.rvBooks.adapter = mBooksAdapter
        binding.rvBooks.layoutManager = LinearLayoutManager(
            binding.root.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }
}