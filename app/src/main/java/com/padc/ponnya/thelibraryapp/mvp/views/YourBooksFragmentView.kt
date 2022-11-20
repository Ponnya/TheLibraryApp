package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

interface YourBooksFragmentView {
    fun showBooks(bookList: List<BookVO>)
    fun tapOnChip(listData: ListData)
    fun showSortByFragment()
    fun showViewAsFragment()
    fun openBookOptionMenu()
    fun changeListView()
    fun changeLargeGridView()
    fun changeSmallGridView()
    fun navigateToDetailScreen()
    fun sortByRecentlyOpened()
    fun sortByTitle()
    fun sortByAuthor()
}