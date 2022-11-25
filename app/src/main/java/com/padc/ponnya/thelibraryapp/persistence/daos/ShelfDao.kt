package com.padc.ponnya.thelibraryapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO

@Dao
interface ShelfDao {

    @Insert(onConflict = REPLACE)
    fun insertSingleShelf(shelfVO: ShelfVO?)

    @Query("SELECT * FROM shelf")
    fun selectAllShelf(): LiveData<List<ShelfVO>>

    @Query("SELECT * FROM shelf where shelfId = :shelfId")
    fun selectSingleShelf(shelfId: Int?): ShelfVO?

    @Update(onConflict = REPLACE)
    fun updateShelf(shelfVO: ShelfVO?)

    @Query("DELETE FROM shelf WHERE shelfId = :shelfId")
    fun deleteShelf(shelfId: Int?)
}