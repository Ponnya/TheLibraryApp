package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomeFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.HomeFragmentView

class HomeFragmentPresenterImpl : ViewModel(), HomeFragmentPresenter {
    private lateinit var mView: HomeFragmentView

    private val mModel: NYTimeModel = NYTimeModelImpl

    override fun initView(view: HomeFragmentView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getOverview(
            {
                mView.showCategoryAndBook(it)
            },
            {
                mView.showError(it)
            }
        )

        mModel.getSavedBook()?.observe(owner) {
            if (it != null) {
                mView.showReadingBook(it)
            }
        }
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
     * BooksByCategoryAdapter.EbooksAdapter.OptionMenuDelegate callback method
     */
    override fun onTapImage(book: BookVO) {
        mModel.saveBookInDatabase(book)
        mView.navigateToDetail()
    }

    /**
     * ReadingBooksAdapter.CarouselOptionMenuDelegate callback method
     */
    override fun onTapCarouselOptionMenu() {
        mView.openBookCarouselOptionMenu()
    }

    /**
     * ReadingBooksAdapter.CarouselOptionMenuDelegate callback method
     */
    override fun onTapCarouselImageView() {
        mView.navigateToDetail()
    }
}