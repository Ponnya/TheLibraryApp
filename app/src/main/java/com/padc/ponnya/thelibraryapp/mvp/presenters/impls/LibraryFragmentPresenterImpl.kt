package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.mvp.presenters.LibraryFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView

class LibraryFragmentPresenterImpl : ViewModel(), LibraryFragmentPresenter {
    private lateinit var mView: LibraryFragmentView
    override fun initView(view: LibraryFragmentView) {
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
}