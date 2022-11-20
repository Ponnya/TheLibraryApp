package com.padc.ponnya.thelibraryapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shelf")
data class ShelfVO(
    @PrimaryKey
    val shelfName: String,

    @ColumnInfo(name = "book_name")
    val bookName: String,
)