package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO

interface HomeFragmentView : BaseView {
    fun showCategoryAndBook(categoryList: List<CategoryVO>)
    fun showReadingBook(bookList: List<BookVO>)
    fun openMoreBookScreen()
    fun openBookCarouselOptionMenu()
    fun openBookOptionMenu()
    fun navigateToDetail()
}