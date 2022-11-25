package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.mvp.presenters.DetailPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.DetailView

class DetailPresenterImpl : ViewModel(), DetailPresenter {
    private lateinit var mView: DetailView
    private val mModel = NYTimeModelImpl
    override fun initView(view: DetailView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner, bookTitle: String) {
        mModel.getBookDetail(bookTitle)?.let {
            mView.showBookDetail(it)
        }
    }

    override fun onUiReady(owner: LifecycleOwner) {
        //Nothing have to do here
    }

    override fun onTapBack() {
        mView.endActivity()
    }
}