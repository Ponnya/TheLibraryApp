package com.padc.ponnya.thelibraryapp.data.models

import androidx.lifecycle.LiveData
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object NYTimeModelImpl : NYTimeModel, BaseModel() {

    override fun getOverview(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        mNYTimeApi.getOverview()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.results?.lists?.let { categoryList ->
                    val data = categoryList.map { categoryVO ->
                        categoryVO.copy(books = categoryVO.books?.map { bookVO ->

                            bookVO.copy(listName = listOf(categoryVO.listName))
                        })
                    }
                    onSuccess(data)
                }
            },
                { onFailure(it.localizedMessage ?: "") })
    }

    override fun saveBookInDatabase(bookVO: BookVO) {
        val book = mLibraryDatabase?.bookDao()?.selectBookByTitle(bookVO.title)
        var data: List<String?>? = null
        var bookData: BookVO? = null
        if (book != null) {
            book.listName?.let { listName ->
                bookVO.listName?.let { listName1 ->
                    data = listOf(listName, listName1).flatten().toSet().toList()
                }
            }
            bookData = book.copy(
                listName = data
            )
        } else {
            bookData = bookVO
        }

        mLibraryDatabase?.bookDao()?.insertSingleBook(bookData)
    }

    override fun getSavedBook(): LiveData<List<BookVO>>? =
        mLibraryDatabase?.bookDao()?.selectAllBooks()

    override fun getMovieDetail() {

    }

}