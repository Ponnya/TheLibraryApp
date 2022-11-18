package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.delegates.ShelfOptionMenuDelegate
import com.padc.ponnya.thelibraryapp.delegates.ViewAsDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.ShelfView
import com.padc.ponnya.thelibraryapp.views.viewpods.BookDisplayAndSortingViewPod

interface ShelfPresenter : ChipDelegate, BookDisplayAndSortingViewPod.Delegate,
    OptionMenuAndDetailDelegate, ViewAsDelegate, ShelfOptionMenuDelegate {
    fun initView(view: ShelfView)
}