package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.YourShelvesFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.YourShelvesFragmentView

class YourShelvesFragmentPresenterImpl : ViewModel(), YourShelvesFragmentPresenter {
    private lateinit var mView: YourShelvesFragmentView
    override fun initView(view: YourShelvesFragmentView) {
        mView = view
    }

    override fun onTapBtnEnterShelf() {
        mView.navigateToShelfScreen()
    }
}