package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.SearchPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.SearchView

class SearchPresenterImpl: ViewModel(),SearchPresenter {
    private lateinit var mView: SearchView
    private val mModel= NYTimeModelImpl
    override fun initView(view: SearchView) {
        mView = view
    }

    override fun searchBook(bookName: String) = mModel.searchBook(bookName)

    override fun onTapBack() {
       mView.backToHomeScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapBook(bookVO: BookVO) {
        mModel.saveBookInDatabase(bookVO)
        mView.navigateToDetail(bookVO.bookTitle)
    }
}