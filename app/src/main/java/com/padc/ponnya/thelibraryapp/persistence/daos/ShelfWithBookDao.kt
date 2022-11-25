package com.padc.ponnya.thelibraryapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padc.ponnya.thelibraryapp.data.vos.ShelfWithBookVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelvesWithBookPair

@Dao
interface ShelfWithBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shelfWithBookVO: ShelfWithBookVO)

    @Transaction
    @Query("SELECT * FROM shelf WHERE shelfId = :shelfId")
    fun getBooks(shelfId: Int): LiveData<ShelvesWithBookPair>

    @Query("Delete FROM shelfWithBook WHERE shelfId =:shelfId")
    fun deleteShelf(shelfId: Int?)
}