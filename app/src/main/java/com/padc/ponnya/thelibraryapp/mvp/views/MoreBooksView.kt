package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.data.vos.BookVO

interface MoreBooksView : BaseView {
    fun openBookOptionMenu()
    fun showBookList(bookList: List<BookVO>)
    fun navigateToDetailScreen()
    fun endActivity()
}