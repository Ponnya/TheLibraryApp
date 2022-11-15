package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.BooksByCategoryDelegate
import com.padc.ponnya.thelibraryapp.delegates.CarouselOptionMenuDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.HomeFragmentView

interface HomeFragmentPresenter : BooksByCategoryDelegate, OptionMenuDelegate,
    CarouselOptionMenuDelegate {
    fun initView(view: HomeFragmentView)
}