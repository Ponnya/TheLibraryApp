package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.ShelfPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.ShelfView
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

class ShelfPresenterImpl : ViewModel(), ShelfPresenter {
    private val mModel: NYTimeModel = NYTimeModelImpl
    private lateinit var mView: ShelfView

    private var mShelfVO: ShelfVO? = null
    override fun initView(view: ShelfView) {
        mView = view
    }

    override fun onUIReady(owner: LifecycleOwner, shelfId: Int) {
        mModel.getBooksFormShelf(shelfId)?.observe(owner) { shelvesWithBookPair ->
            shelvesWithBookPair?.let { data ->
                mShelfVO = data.shelfVO
                mShelfVO?.let { mView.showShelfTitleAndBookCount(it) }

                val bookList: MutableList<BookVO> = mutableListOf()
                data.shelfWithBook.forEach {
                    bookList.add(it.book)
                }
                mView.showBooks(bookList)
            }
        }

    }

    override fun onTapShelfOptionMenu() {
        mView.openShelfOptionMenu()
    }

    override fun onTapBack() {
        mView.navigateToHomeScreen()
    }

    override fun onTapDoneButton(shelfVO: ShelfVO) {
        mModel.updateShelf(shelfVO)
    }

    override fun onUiReady(owner: LifecycleOwner) {
        //Nothing have to do here
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
    override fun onTapOptionMenu(bookVO: BookVO) {
        mView.openBookOptionMenu(bookVO)
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
     * ShelfOptionMenuDelegate callback method
     */
    override fun onTapRename() {
        mView.renameShelf()
    }

    /**
     * ShelfOptionMenuDelegate callback method
     */
    override fun onTapDelete() {
        mView.navigateToHomeScreen()
        mShelfVO?.shelfId?.let { mModel.deleteShelf(it) }
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