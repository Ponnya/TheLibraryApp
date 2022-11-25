package com.padc.ponnya.thelibraryapp.views.viewholders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.databinding.ViewHolderShelvesBinding
import com.padc.ponnya.thelibraryapp.delegates.ShelvesDelegate
import com.padc.ponnya.thelibraryapp.utils.ADD_TO_SHELVES
import com.padc.ponnya.thelibraryapp.utils.YOUR_SHELVES

class ShelvesViewHolder(
    private val delegate: ShelvesDelegate,
    private val binding: ViewHolderShelvesBinding
) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var mShelfVO: ShelfVO

    init {
        binding.btnEnterShelve.setOnClickListener {

            delegate.onTapBtnEnterShelf(mShelfVO.shelfId)
        }

        binding.checkbox.setOnCheckedChangeListener { _, b ->
            if (b) {
                delegate.onTapCheckBox(mShelfVO)
            } else {
                delegate.unCheckedCheckBox(mShelfVO)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun bindData(shelfVO: ShelfVO, shelvesScreenType: String) {
        mShelfVO = shelfVO
        if (!shelfVO.shelfCover.isNullOrEmpty()) {
            Glide.with(binding.root)
                .load(shelfVO.shelfCover)
                .into(binding.ivShelvesCover)
        } else {
            Glide.with(binding.root)
                .load(R.drawable.shelves_47dp)
                .into(binding.ivShelvesCover)
        }


        binding.tvShelveName.text = shelfVO.shelfName
        shelfVO.bookCount.let {
            when (it) {
                0, 1 -> {
                    binding.tvNumberOfBooks.text = "$it book"
                }
                else -> {
                    binding.tvNumberOfBooks.text = "$it books"
                }
            }
        }


        when (shelvesScreenType) {
            ADD_TO_SHELVES -> {
                binding.checkbox.visibility = View.VISIBLE
                binding.btnEnterShelve.visibility = View.GONE
            }
            YOUR_SHELVES -> {
                binding.checkbox.visibility = View.GONE
                binding.btnEnterShelve.visibility = View.VISIBLE
            }
        }
    }
}