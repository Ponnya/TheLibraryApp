package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.mvp.views.CreateShelfView

interface CreateShelfPresenter : IBasePresenter {
    fun initView(view: CreateShelfView)
    fun onTapDoneButton(shelfVO: ShelfVO)
    fun onTapBackButton()
}