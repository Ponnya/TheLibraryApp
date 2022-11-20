package com.padc.ponnya.thelibraryapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO

@Dao
interface ShelfDao {

    @Insert(onConflict = REPLACE)
    fun insertSingleShelf(shelfVO: ShelfVO?)

    @Query("SELECT * FROM shelf")
    fun selectAllShelf(): LiveData<List<ShelfVO>>

    @Query("DELETE FROM shelf WHERE shelfName = :shelfName")
    fun deleteShelf(shelfName: String?)
}