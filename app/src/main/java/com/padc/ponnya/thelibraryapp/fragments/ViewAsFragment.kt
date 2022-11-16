package com.padc.ponnya.thelibraryapp.fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.databinding.FragmentViewAsBinding
import com.padc.ponnya.thelibraryapp.delegates.ViewAsDelegate
import com.padc.ponnya.thelibraryapp.utils.LARGE_GIRD
import com.padc.ponnya.thelibraryapp.utils.LIST
import com.padc.ponnya.thelibraryapp.utils.SMALL_GIRD

class ViewAsFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentViewAsBinding
    private lateinit var mDelegate: ViewAsDelegate

    private var mCheckedRadioButton = LIST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewAsBinding.inflate(inflater, container, false)
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

    override fun onDismiss(dialog: DialogInterface) {
        val bottomSheet =
            (dialog as BottomSheetDialog).findViewById(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
        BottomSheetBehavior.from(bottomSheet!!).state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRadioChecked()
        setUpListener()

    }

    fun setUpViewAsFragment(delegate: ViewAsDelegate, checkRadioButton: String) {
        mDelegate = delegate
        mCheckedRadioButton = checkRadioButton

    }

    private fun setUpListener() {
        binding.radioGroupViewAs.setOnCheckedChangeListener { _, i ->
            when (i) {
                binding.rbList.id -> {
                    mDelegate.showListView()
                    dismiss()
                }
                binding.rbLargeGrid.id -> {
                    mDelegate.showLargeGridView()
                    dismiss()
                }
                binding.rbSmallGrid.id -> {
                    mDelegate.showSmallGridView()
                    dismiss()

                }
            }
        }

    }

    private fun setUpRadioChecked() {
        when (mCheckedRadioButton) {
            LIST -> {
                binding.rbList.isChecked = true
            }
            LARGE_GIRD -> {
                binding.rbLargeGrid.isChecked = true
            }
            SMALL_GIRD -> {
                binding.rbSmallGrid.isChecked = true
            }
        }
    }

}