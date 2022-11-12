package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.BooksByCategoryDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.HomeView

interface HomePresenter : IBasePresenter, BooksByCategoryDelegate, OptionMenuDelegate {
    fun initView(view: HomeView)
    fun onTapOptionMenuScreen()
}