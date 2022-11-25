package com.padc.ponnya.thelibraryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.delegates.*
import com.padc.ponnya.thelibraryapp.mvp.views.ShelfView
import com.padc.ponnya.thelibraryapp.views.viewpods.BookDisplayAndSortingViewPod

interface ShelfPresenter : IBasePresenter, ChipDelegate, BookDisplayAndSortingViewPod.Delegate,
    OptionMenuAndDetailDelegate, ViewAsDelegate, ShelfOptionMenuDelegate, SortByDelegate {
    fun initView(view: ShelfView)
    fun onUIReady(owner: LifecycleOwner, shelfId: Int)
    fun onTapShelfOptionMenu()
    fun onTapBack()
    fun onTapDoneButton(shelfVO: ShelfVO)
}