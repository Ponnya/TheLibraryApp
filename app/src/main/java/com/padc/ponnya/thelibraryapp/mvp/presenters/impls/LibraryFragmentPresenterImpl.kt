package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.LibraryFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView

class LibraryFragmentPresenterImpl : ViewModel(), LibraryFragmentPresenter {
    private lateinit var mView: LibraryFragmentView

    override fun initView(view: LibraryFragmentView) {
        mView = view
    }

    override fun onTapYourBooksTab() {
        mView.showYourBooksFragment()
    }

    override fun onTapYourShelvesTab() {
        mView.showYourShelvesFragment()
    }


}