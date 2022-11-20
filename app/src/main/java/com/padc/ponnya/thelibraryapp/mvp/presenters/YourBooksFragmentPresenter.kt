package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.delegates.SortByDelegate
import com.padc.ponnya.thelibraryapp.delegates.ViewAsDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.YourBooksFragmentView
import com.padc.ponnya.thelibraryapp.views.viewpods.BookDisplayAndSortingViewPod

interface YourBooksFragmentPresenter : IBasePresenter, ChipDelegate,
    BookDisplayAndSortingViewPod.Delegate,
    OptionMenuAndDetailDelegate, ViewAsDelegate, SortByDelegate {
    fun initView(view: YourBooksFragmentView)
}