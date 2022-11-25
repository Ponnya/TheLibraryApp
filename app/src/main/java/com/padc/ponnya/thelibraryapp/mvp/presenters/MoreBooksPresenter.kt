package com.padc.ponnya.thelibraryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

interface MoreBooksPresenter : IBasePresenter, OptionMenuAndDetailDelegate {
    fun initView(view: MoreBooksView)
    fun onUiReady(owner: LifecycleOwner, list: String)
    fun onTapBack()
}