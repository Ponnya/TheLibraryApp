package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.delegates.ShelvesDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.YourShelvesFragmentView

interface YourShelvesFragmentPresenter : IBasePresenter, ShelvesDelegate {
    fun initView(view: YourShelvesFragmentView)
    fun onTapCreateNew()
}