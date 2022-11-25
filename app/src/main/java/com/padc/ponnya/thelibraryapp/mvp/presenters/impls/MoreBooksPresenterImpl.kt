package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.MoreBooksPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

class MoreBooksPresenterImpl : ViewModel(), MoreBooksPresenter {
    private lateinit var mView: MoreBooksView
    private val mModel = NYTimeModelImpl

    override fun initView(view: MoreBooksView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner, list: String) {
        mModel.getList(
            list = list,
            onSuccess = {
                        var bookList: MutableList<List<BookVO>> = mutableListOf()
                it.forEach {
                    it.bookDetail?.let { book -> bookList.add(book) }
                }
                mView.showBookList(bookList.flatten())
            },
            onFailure = {
                mView.showError(it)
            }
        )
    }

    override fun onTapBack() {
        mView.endActivity()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        //Nothing have to do here
    }

    /**
     * MoreEbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapOptionMenu(bookVO: BookVO) {
        mView.openBookOptionMenu()
    }

    /**
     * MoreEbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapImage(book: BookVO) {
        mView.navigateToDetailScreen()
    }
}