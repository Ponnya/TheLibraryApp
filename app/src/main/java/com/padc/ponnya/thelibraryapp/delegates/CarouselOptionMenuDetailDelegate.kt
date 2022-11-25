package com.padc.ponnya.thelibraryapp.delegates

import com.padc.ponnya.thelibraryapp.data.vos.BookVO

interface CarouselOptionMenuDetailDelegate {
    fun onTapCarouselOptionMenu(bookVO: BookVO)
    fun onTapCarouselImageView(bookTile: String)
    fun onTapAddToShelves()
}