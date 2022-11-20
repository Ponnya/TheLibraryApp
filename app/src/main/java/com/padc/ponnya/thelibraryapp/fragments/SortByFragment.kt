package com.padc.ponnya.thelibraryapp.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.databinding.FragmentSortByBinding
import com.padc.ponnya.thelibraryapp.delegates.SortByDelegate
import com.padc.ponnya.thelibraryapp.utils.AUTHOR
import com.padc.ponnya.thelibraryapp.utils.RECENTLY_OPENED
import com.padc.ponnya.thelibraryapp.utils.TITLE

class SortByFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSortByBinding
    private lateinit var mDelegate: SortByDelegate

    private var mCheckedRadioButton = RECENTLY_OPENED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSortByBinding.inflate(inflater, container, false)
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

        setUpRadioChecked()
        setUpListener()
    }

    fun setUpSortByFragment(delegate: SortByDelegate, checkRadioButton: String) {
        mDelegate = delegate
        mCheckedRadioButton = checkRadioButton

    }


    private fun setUpListener() {
        binding.radioGroupSortBy.setOnCheckedChangeListener { _, i ->
            when (i) {
                binding.rbRecentlyOpened.id -> {
                    mDelegate.sortByRecently()
                    dismiss()
                }
                binding.rbTitle.id -> {
                    mDelegate.sortByTitle()
                    dismiss()
                }
                binding.rbAuthor.id -> {
                    mDelegate.sortByAuthor()
                    dismiss()

                }
            }
        }

    }

    private fun setUpRadioChecked() {
        when (mCheckedRadioButton) {
            RECENTLY_OPENED -> {
                binding.rbRecentlyOpened.isChecked = true
            }
            TITLE -> {
                binding.rbTitle.isChecked = true
            }
            AUTHOR -> {
                binding.rbAuthor.isChecked = true
            }
        }
    }


}