package com.padc.ponnya.thelibraryapp.delegates

import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO

interface ShelvesDelegate {
    fun onTapBtnEnterShelf(shelfID: Int)
    fun onTapCheckBox(shelfVO: ShelfVO?)
    fun unCheckedCheckBox(shelfVO: ShelfVO?)
}