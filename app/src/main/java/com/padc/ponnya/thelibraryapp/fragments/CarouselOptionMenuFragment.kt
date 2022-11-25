package com.padc.ponnya.thelibraryapp.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.FragmentCarouselOptionMenuBinding
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDetailDelegate

class CarouselOptionMenuFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCarouselOptionMenuBinding
    private lateinit var mDelegate: CarouselOptionMenuDetailDelegate
    private lateinit var mBookVO: BookVO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarouselOptionMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener {
                val bottomSheet =
                    (it as BottomSheetDialog).findViewById(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
                BottomSheetBehavior.from(bottomSheet!!).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        bindData(mBookVO)
    }

    private fun setUpListener() {
        binding.llAdd.setOnClickListener {
            mDelegate.onTapAddToShelves()
            dismiss()
        }

    }

    private fun bindData(bookVO: BookVO) {
        Glide.with(binding.root)
            .load(bookVO.bookImage)
            .into(binding.ivCover)

        binding.tvBookName.text = bookVO.bookTitle
        binding.tvAuthor.text = bookVO.author
    }

    fun setUpCarouselOptionMenuFragment(
        delegate: CarouselOptionMenuDetailDelegate,
        bookVO: BookVO
    ) {
        mDelegate = delegate
        mBookVO = bookVO
    }


}