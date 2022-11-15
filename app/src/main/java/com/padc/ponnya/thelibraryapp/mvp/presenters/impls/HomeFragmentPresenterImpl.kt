package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomeFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.HomeFragmentView

class HomeFragmentPresenterImpl : ViewModel(), HomeFragmentPresenter {
    private lateinit var mView: HomeFragmentView
    override fun initView(view: HomeFragmentView) {
        mView = view
    }

    /**
     * BooksByCategoryAdapter.BooksByCategoryDelegate callback method
     */
    override fun onTapBtnMore() {
        mView.openMoreBookScreen()
    }

    /**
     * BooksByCategoryAdapter.EbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapOptionMenu() {
        mView.openBookOptionMenu()
    }

    /**
     * ReadingBooksAdapter.CarouselOptionMenuDelegate callback method
     */
    override fun onTapCarouselOptionMenu() {
        mView.openBookCarouselOptionMenu()
    }
}