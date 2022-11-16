package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate
import com.padc.ponnya.thelibraryapp.delegates.ViewAsDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView
import com.padc.ponnya.thelibraryapp.views.viewpods.BookDisplayAndSortingViewPod

interface LibraryFragmentPresenter : ChipDelegate, BookDisplayAndSortingViewPod.Delegate,
    OptionMenuDelegate, ViewAsDelegate {
    fun initView(view: LibraryFragmentView)
}