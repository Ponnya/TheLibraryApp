package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.MoreBooksPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

class MoreBooksPresenterImpl : ViewModel(), MoreBooksPresenter {
    private lateinit var mView: MoreBooksView

    override fun initView(view: MoreBooksView) {
        mView = view
    }

    override fun onTapOptionMenuScreen() {
        mView.closeBookOptionMenu()
    }

    /**
     * MoreEbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapOptionMenu() {
        mView.openBookOptionMenu()
    }
}