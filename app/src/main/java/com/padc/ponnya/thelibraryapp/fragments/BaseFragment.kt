package com.padc.ponnya.thelibraryapp.fragments

import androidx.fragment.app.Fragment
import com.padc.ponnya.thelibraryapp.mvp.views.BaseView

abstract class BaseFragment : Fragment(), BaseView {
    override fun showError(errorString: String) {
        //    Snackbar.make(requireActivity().findViewById(R.id.coordinatorLayout), errorString, Snackbar.LENGTH_SHORT).show()
    }
}