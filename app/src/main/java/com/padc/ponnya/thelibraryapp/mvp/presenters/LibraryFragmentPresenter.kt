package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.delegates.ViewAsDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView
import com.padc.ponnya.thelibraryapp.views.viewpods.BookDisplayAndSortingViewPod

interface LibraryFragmentPresenter : ChipDelegate, BookDisplayAndSortingViewPod.Delegate,
    OptionMenuAndDetailDelegate, ViewAsDelegate {
    fun initView(view: LibraryFragmentView)
}