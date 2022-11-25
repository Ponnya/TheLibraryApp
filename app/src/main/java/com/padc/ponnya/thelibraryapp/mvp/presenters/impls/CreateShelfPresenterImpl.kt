package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.CreateShelfPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.CreateShelfView

class CreateShelfPresenterImpl : ViewModel(), CreateShelfPresenter {
    private lateinit var mView: CreateShelfView
    private val mModel = NYTimeModelImpl

    override fun initView(view: CreateShelfView) {
        mView = view
    }

    override fun onTapDoneButton(shelfVO: ShelfVO) {
        if (!shelfVO.shelfName.isNullOrEmpty()) {
            mModel.createShelf(shelfVO)
            mView.endActivity()
        } else {
            mView.showError("Shelf name must not be empty")
        }

    }

    override fun onTapBackButton() {
        mView.endActivity()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}