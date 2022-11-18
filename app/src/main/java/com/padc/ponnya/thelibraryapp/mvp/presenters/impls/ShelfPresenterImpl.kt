package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.ShelfPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.ShelfView

class ShelfPresenterImpl : ViewModel(), ShelfPresenter {
    private lateinit var mView: ShelfView
    override fun initView(view: ShelfView) {
        mView = view
    }

    override fun onTapChip(position: Int) {
        mView.tapOnChip(position)
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
    override fun onTapImage() {
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
     * ShelfOptionMenuDelegate callback method
     */
    override fun onTapRename() {
        mView.renameShelf()
    }

    /**
     * ShelfOptionMenuDelegate callback method
     */
    override fun onTapDelete() {
        mView.deleteShelf()
    }
}