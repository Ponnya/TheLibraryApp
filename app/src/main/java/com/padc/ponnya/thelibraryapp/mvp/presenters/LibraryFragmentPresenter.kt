package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView

interface LibraryFragmentPresenter {
    fun initView(view: LibraryFragmentView)
    fun onTapYourBooksTab()
    fun onTapYourShelvesTab()
}