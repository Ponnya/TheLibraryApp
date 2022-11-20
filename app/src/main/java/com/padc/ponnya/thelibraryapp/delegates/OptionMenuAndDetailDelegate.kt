package com.padc.ponnya.thelibraryapp.delegates

import com.padc.ponnya.thelibraryapp.data.vos.BookVO

interface OptionMenuAndDetailDelegate {
    fun onTapOptionMenu()
    fun onTapImage(book: BookVO)
}