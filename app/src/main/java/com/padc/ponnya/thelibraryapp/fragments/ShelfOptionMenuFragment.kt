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
import com.padc.ponnya.thelibraryapp.databinding.FragmentShelfOptionMenuBinding
import com.padc.ponnya.thelibraryapp.delegates.ShelfOptionMenuDelegate


class ShelfOptionMenuFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentShelfOptionMenuBinding
    private lateinit var mDelegate: ShelfOptionMenuDelegate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShelfOptionMenuBinding.inflate(inflater, container, false)
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
    }

    fun setUpDelegate(delegate: ShelfOptionMenuDelegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        binding.llRename.setOnClickListener {
            mDelegate.onTapRename()
            dismiss()
        }
    }
}