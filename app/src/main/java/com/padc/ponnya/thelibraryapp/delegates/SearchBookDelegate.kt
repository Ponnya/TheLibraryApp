package com.padc.ponnya.thelibraryapp.delegates

import com.padc.ponnya.thelibraryapp.data.vos.BookVO

interface SearchBookDelegate {
    fun onTapBook(bookVO: BookVO)
}