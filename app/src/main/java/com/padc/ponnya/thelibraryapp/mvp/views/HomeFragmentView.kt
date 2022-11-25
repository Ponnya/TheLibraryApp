package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO

interface HomeFragmentView : BaseView {
    fun showCategoryAndBook(categoryList: List<CategoryVO>)
    fun showReadingBook(bookList: List<BookVO>)
    fun openMoreBookScreen()
    fun openBookCarouselOptionMenu(bookVO: BookVO)
    fun openBookOptionMenu(bookVO: BookVO)
    fun navigateToDetail()
    fun openAddToShelvesScreen(bookTile: String)
}