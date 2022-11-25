package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.AddToShelvesPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.AddToShelvesView

class AddToShelvesPresenterImpl : ViewModel(), AddToShelvesPresenter {
    private lateinit var mView: AddToShelvesView
    private val mModel = NYTimeModelImpl
    private var mShelfSetList: MutableSet<ShelfVO> = mutableSetOf()

    override fun initView(view: AddToShelvesView) {
        mView = view
    }

    override fun onTapCloseButton(bookTitle: String) {
        if (mShelfSetList.isNotEmpty()) {

            mModel.addBook(bookTitle, mShelfSetList.toList())

        }

        mView.closeAddToShelvesScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getShelves()?.observe(owner) {
            if (!it.isNullOrEmpty()) {
                mView.showShelves(it)
            }
        }
        mModel.getSavedBook()
    }

    /**
     * SortByDelegate callback method
     */
    override fun onTapBtnEnterShelf(shelfID: Int) {
        //Nothing have to do here
    }

    /**
     * SortByDelegate callback method
     */
    override fun onTapCheckBox(shelfVO: ShelfVO?) {
        if (shelfVO != null) {
            mShelfSetList.add(shelfVO)
        }
    }

    override fun unCheckedCheckBox(shelfVO: ShelfVO?) {
        if (shelfVO != null) {
            mShelfSetList.remove(shelfVO)
        }
    }
}