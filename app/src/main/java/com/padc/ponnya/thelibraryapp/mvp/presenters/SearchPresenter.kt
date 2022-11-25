package com.padc.ponnya.thelibraryapp.mvp.presenters

import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.delegates.SearchBookDelegate
import com.padc.ponnya.thelibraryapp.mvp.views.SearchView
import io.reactivex.rxjava3.core.Observable

interface SearchPresenter : IBasePresenter, SearchBookDelegate {
    fun initView(view: SearchView)
    fun searchBook(bookName: String): Observable<List<BookVO>>
    fun onTapBack()
}