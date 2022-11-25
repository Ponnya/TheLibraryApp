package com.padc.ponnya.thelibraryapp.data.models

import androidx.lifecycle.LiveData
import com.padc.ponnya.thelibraryapp.data.vos.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

object NYTimeModelImpl : NYTimeModel, BaseModel() {

    override fun getOverview(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        mNYTimeApi.getOverview().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                it.results?.lists?.let { categoryList ->
                    val data = categoryList.map { categoryVO ->
                        categoryVO.copy(books = categoryVO.books?.map { bookVO ->

                            bookVO.copy(listName = listOf(categoryVO.listName))
                        })
                    }
                    onSuccess(data)
                }
            }, { onFailure(it.localizedMessage ?: "") })
    }

    override fun saveBookInDatabase(bookVO: BookVO) {
        val book = mLibraryDatabase?.bookDao()?.selectBookByTitle(bookVO.bookTitle)
        var data: List<String?>? = null
        var bookData: BookVO?
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

    override fun getBookDetail(bookTitle: String): BookVO? =
        mLibraryDatabase?.bookDao()?.selectBookByTitle(bookTitle)


    override fun createShelf(shelf: ShelfVO) {
        mLibraryDatabase?.shelfDao()?.insertSingleShelf(shelf)
    }

    override fun addBook(bookTitle: String, shelfList: List<ShelfVO>) {
        val book = mLibraryDatabase?.bookDao()?.selectBookByTitle(bookTitle)
        shelfList.forEach {
            val toUpdateShelf =
                mLibraryDatabase?.shelfDao()?.selectSingleShelf(it.shelfId)?.let { shelf ->
                    shelf.copy(
                        bookCount = shelf.bookCount + 1, shelfCover = book?.bookImage
                    )
                }


            if (toUpdateShelf != null) {
                updateShelf(toUpdateShelf)
                mLibraryDatabase?.shelfWithBookDao()
                    ?.insert(ShelfWithBookVO(toUpdateShelf.shelfId, bookTitle))
            }
        }

    }

    override fun getShelves(): LiveData<List<ShelfVO>>? {
        return mLibraryDatabase?.shelfDao()?.selectAllShelf()
    }

    override fun updateShelf(shelfVO: ShelfVO) {
        mLibraryDatabase?.shelfDao()?.updateShelf(shelfVO)
    }

    override fun deleteShelf(shelfId: Int) {
        // delete from shelfWithBook Table
        mLibraryDatabase?.shelfWithBookDao()?.deleteShelf(shelfId)

        // delete from shelf Table
        mLibraryDatabase?.shelfDao()?.deleteShelf(shelfId)
    }

    override fun getBooksFormShelf(shelfId: Int): LiveData<ShelvesWithBookPair>? {
        return mLibraryDatabase?.shelfWithBookDao()?.getBooks(shelfId)
    }

    override fun getList(
        list: String, onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit
    ) {
        mNYTimeApi.getList(list = list).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                it.results?.let(onSuccess)
            }, {
                onFailure(it.localizedMessage ?: "")
            })
    }

    override fun searchBook(
        q: String
    ): Observable<List<BookVO>> = mNYTimeApi.searchBooks(q = q).map {
        val data: MutableList<BookVO> = mutableListOf()
        it.items?.forEach { item ->
            item.volumeInfo?.let { googleBook -> data.add(googleBook.convertToBookVO()) }
        }
        data.toList()
    }.onErrorResumeNext { Observable.just(listOf()) }.subscribeOn(Schedulers.io())


}