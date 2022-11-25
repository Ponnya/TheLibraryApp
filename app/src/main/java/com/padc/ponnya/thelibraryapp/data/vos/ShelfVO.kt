package com.padc.ponnya.thelibraryapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shelf")
data class ShelfVO(

    @ColumnInfo(name = "shelf_name")
    val shelfName: String,

    @PrimaryKey(autoGenerate = true)
    val shelfId: Int = 0,

    @ColumnInfo(name = "shelf_cover")
    val shelfCover: String?,

    @ColumnInfo(name = "book_count")
    val bookCount: Int = 0,
)