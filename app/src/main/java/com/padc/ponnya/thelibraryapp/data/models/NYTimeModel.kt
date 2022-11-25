package com.padc.ponnya.thelibraryapp.data.models

import androidx.lifecycle.LiveData
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelvesWithBookPair

interface NYTimeModel {

    fun getOverview(
        onSuccess: (List<CategoryVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun saveBookInDatabase(bookVO: BookVO)

    fun getSavedBook(): LiveData<List<BookVO>>?

    fun getMovieDetail()

    fun createShelf(shelf: ShelfVO)

    fun addBook(bookTitle: String, shelfList: List<ShelfVO>)

    fun getShelves(): LiveData<List<ShelfVO>>?

    fun updateShelf(shelfVO: ShelfVO)

    fun deleteShelf(shelfId: Int)

    fun getBooksFormShelf(shelfId: Int): LiveData<ShelvesWithBookPair>?

}
