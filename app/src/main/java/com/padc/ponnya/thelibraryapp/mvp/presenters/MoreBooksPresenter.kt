package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

interface MoreBooksPresenter : IBasePresenter, OptionMenuAndDetailDelegate {
    fun initView(view: MoreBooksView)
    fun onTapBack()
}