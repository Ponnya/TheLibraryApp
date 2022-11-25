package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.mvp.views.HomeView

interface HomePresenter : IBasePresenter {
    fun initView(view: HomeView)
}