package com.padc.ponnya.thelibraryapp.data.models

import androidx.lifecycle.LiveData
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO

interface NYTimeModel {

    fun getOverview(
        onSuccess: (List<CategoryVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun saveBookInDatabase(bookVO: BookVO)

    fun getSavedBook(): LiveData<List<BookVO>>?

    fun getMovieDetail()
}
