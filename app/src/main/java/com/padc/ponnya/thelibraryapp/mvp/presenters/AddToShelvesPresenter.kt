package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.ShelvesDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.AddToShelvesView

interface AddToShelvesPresenter : IBasePresenter, ShelvesDelegate {
    fun initView(view: AddToShelvesView)
    fun onTapCloseButton(bookTitle: String)
}