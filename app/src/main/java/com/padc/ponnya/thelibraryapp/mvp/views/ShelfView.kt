package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

interface ShelfView {
    fun tapOnChip(listData: ListData)
    fun showSortByFragment()
    fun showViewAsFragment()
    fun openBookOptionMenu()
    fun changeListView()
    fun changeLargeGridView()
    fun changeSmallGridView()
    fun navigateToDetailScreen()
    fun renameShelf()
    fun deleteShelf()
}