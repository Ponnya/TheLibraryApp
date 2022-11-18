package com.padc.ponnya.thelibraryapp.mvp.views

interface ShelfView {
    fun tapOnChip(position: Int)
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