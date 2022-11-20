package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.YourBooksFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.YourBooksFragmentView
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

class YourBooksFragmentPresenterImpl : ViewModel(), YourBooksFragmentPresenter {
    private lateinit var mView: YourBooksFragmentView

    private val mModel = NYTimeModelImpl

    override fun initView(view: YourBooksFragmentView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getSavedBook()?.observe(owner) {
            if (it != null) {
                mView.showBooks(it)
            }
        }
    }

    override fun onTapChip(listData: ListData) {
        mView.tapOnChip(listData)
    }

    /**
     * BookDisplayAndSortingViewPod.Delegate callback method
     */
    override fun onTapBtnSortBy() {
        mView.showSortByFragment()
    }

    /**
     * BookDisplayAndSortingViewPod.Delegate callback method
     */
    override fun onTapBtnViewAs() {
        mView.showViewAsFragment()
    }

    /**
     * MoreEbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapOptionMenu() {
        mView.openBookOptionMenu()
    }

    /**
     * MoreEbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapImage(book: BookVO) {
        mView.navigateToDetailScreen()
    }

    /**
     * ViewAsDelegate callback method
     */
    override fun showListView() {
        mView.changeListView()
    }

    /**
     * ViewAsDelegate callback method
     */
    override fun showLargeGridView() {
        mView.changeLargeGridView()
    }

    /**
     * ViewAsDelegate callback method
     */
    override fun showSmallGridView() {
        mView.changeSmallGridView()
    }

    /**
     * SortByDelegate callback method
     */
    override fun sortByRecently() {
        mView.sortByRecentlyOpened()
    }

    /**
     * SortByDelegate callback method
     */
    override fun sortByTitle() {
        mView.sortByTitle()
    }

    /**
     * SortByDelegate callback method
     */
    override fun sortByAuthor() {
        mView.sortByAuthor()
    }
}