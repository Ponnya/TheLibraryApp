package com.padc.ponnya.thelibraryapp.mvp.views

import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO

interface AddToShelvesView : BaseView {
    fun showShelves(shelves: List<ShelfVO>)
    fun closeAddToShelvesScreen()
}