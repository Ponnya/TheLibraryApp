package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

interface MoreBooksPresenter : IBasePresenter, OptionMenuDelegate {
    fun initView(view: MoreBooksView)
}