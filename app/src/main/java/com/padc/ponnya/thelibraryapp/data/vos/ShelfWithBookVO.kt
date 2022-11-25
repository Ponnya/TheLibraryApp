package com.padc.ponnya.thelibraryapp.data.vos

import androidx.room.Entity

@Entity(tableName = "shelfWithBook", primaryKeys = ["shelfId", "bookTitle"])
data class ShelfWithBookVO(
    val shelfId: Int,
    val bookTitle: String,
)