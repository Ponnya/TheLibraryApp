package com.padc.ponnya.thelibraryapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderBooksByCategoryBinding
import com.padc.ponnya.thelibraryapp.delegates.BooksByCategoryDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.BooksByCategoryViewHolder

class BooksByCategoryAdapter(
    private val mOptionMenuDelegate: OptionMenuAndDetailDelegate,
    private val delegate: BooksByCategoryDelegate
) :
    RecyclerView.Adapter<BooksByCategoryViewHolder>() {

    private var mCategoryList: List<CategoryVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksByCategoryViewHolder {
        val view = ViewHolderBooksByCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BooksByCategoryViewHolder(mOptionMenuDelegate, delegate, view)
    }

    override fun onBindViewHolder(holder: BooksByCategoryViewHolder, position: Int) {
        if (mCategoryList.isNotEmpty()) {
            holder.bindData(mCategoryList[position])
        }
    }

    override fun getItemCount(): Int = mCategoryList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(categoryList: List<CategoryVO>) {
        mCategoryList = categoryList
        notifyDataSetChanged()
    }
}