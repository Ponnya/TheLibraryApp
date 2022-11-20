package com.padc.ponnya.thelibraryapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.padc.ponnya.thelibraryapp.data.vos.BookVO

@Dao
interface BookDao {
    @Insert(onConflict = REPLACE)
    fun insertBooks(books: List<BookVO>)

    @Insert(onConflict = REPLACE)
    fun insertSingleBook(book: BookVO?)

    @Query("SELECT * FROM books")
    fun selectAllBooks(): LiveData<List<BookVO>>

    @Query("SELECT * FROM books WHERE title = :title ")
    fun selectBookByTitle(title: String): BookVO?

    @Query("DELETE FROM books")
    fun deleteAllBooks()

}