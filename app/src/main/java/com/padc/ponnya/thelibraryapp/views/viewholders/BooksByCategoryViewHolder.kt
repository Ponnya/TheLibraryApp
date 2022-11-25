package com.padc.ponnya.thelibraryapp.views.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.adapters.EbooksAdapter
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO
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
    private var mList: String? =null
    init {
        binding.btnSeeMore.setOnClickListener {
            mList?.let { list -> delegate.onTapBtnMore(list) }
        }
    }

    fun bindData(categoryVO: CategoryVO) {
        mList = categoryVO.listName
        mEbooksAdapter = EbooksAdapter(mOptionMenuDelegate)
        binding.tvCategoryLabel.text = categoryVO.listName
        binding.rvBooks.adapter = mEbooksAdapter
        binding.rvBooks.layoutManager = LinearLayoutManager(
            binding.root.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        categoryVO.books?.let { mEbooksAdapter.setNewData(it) }
    }
}