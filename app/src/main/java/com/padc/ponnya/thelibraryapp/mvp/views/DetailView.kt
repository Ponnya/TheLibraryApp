package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.data.vos.BookVO

interface DetailView : BaseView {
    fun showBookDetail(bookVO: BookVO)
    fun endActivity()
}