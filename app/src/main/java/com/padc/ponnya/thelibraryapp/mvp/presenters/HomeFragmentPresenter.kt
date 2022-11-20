package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.BooksByCategoryDelegate
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDetailDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.HomeFragmentView

interface HomeFragmentPresenter : IBasePresenter, BooksByCategoryDelegate,
    OptionMenuAndDetailDelegate,
    CarouselOptionMenuDetailDelegate {
    fun initView(view: HomeFragmentView)

}