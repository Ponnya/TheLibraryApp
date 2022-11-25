package com.padc.ponnya.thelibraryapp.delegates

import com.padc.ponnya.thelibraryapp.data.vos.BookVO

interface OptionMenuAndDetailDelegate {
    fun onTapOptionMenu(bookVO: BookVO)
    fun onTapImage(book: BookVO)
}