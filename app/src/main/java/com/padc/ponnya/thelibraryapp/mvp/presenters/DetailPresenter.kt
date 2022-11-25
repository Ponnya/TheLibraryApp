package com.padc.ponnya.thelibraryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.thelibraryapp.mvp.views.DetailView

interface DetailPresenter : IBasePresenter {
    fun initView(view: DetailView)
    fun onUiReady(owner: LifecycleOwner, bookTitle: String)
    fun onTapBack()
}