package com.padc.ponnya.thelibraryapp.mvp.views

interface LibraryFragmentView {
    fun tapOnChip(position: Int)
    fun showSortByFragment()
    fun showViewAsFragment()
    fun openBookOptionMenu()
    fun changeListView()
    fun changeLargeGridView()
    fun changeSmallGridView()
}