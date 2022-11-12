package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomePresenter
import com.padc.ponnya.thelibraryapp.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter {
    private lateinit var mHomeView: HomeView
    override fun initView(view: HomeView) {
        mHomeView = view
    }


    override fun onTapOptionMenuScreen() {
        mHomeView.closeBookOptionMenu()
    }

    /**
     * BooksByCategoryAdapter.BooksByCategoryDelegate callback method
     */
    override fun onTapBtnMore() {
        mHomeView.openMoreBookScreen()
    }

    /**
     * BooksByCategoryAdapter.EbooksAdapter.OptionMenuDelegate callback method
     * ReadingBooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapOptionMenu() {
        mHomeView.openBookOptionMenu()
    }
}