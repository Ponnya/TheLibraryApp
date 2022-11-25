package com.padc.ponnya.thelibraryapp.data.vos

import androidx.room.Embedded
import androidx.room.Relation

data class ShelvesWithBookPair(

    @Embedded
    val shelfVO: ShelfVO,

    @Relation(
        parentColumn = "shelfId",
        entity = ShelfWithBookVO::class,
        entityColumn = "shelfId",
    )
    val shelfWithBook: List<ShelfWithBookPair>,
)

data class ShelfWithBookPair(
    @Embedded
    val shelfWithBookVO: ShelfWithBookVO,

    @Relation(
        entity = BookVO::class,
        parentColumn = "bookTitle",
        entityColumn = "bookTitle"
    )
    val book: BookVO,
)
