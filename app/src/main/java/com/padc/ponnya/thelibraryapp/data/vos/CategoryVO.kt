package com.padc.ponnya.thelibraryapp.data.vos

import com.google.gson.annotations.SerializedName

data class CategoryVO(
    @SerializedName("list_id")
    val listId: Int?,

    @SerializedName("list_name")
    val listName: String?,

    @SerializedName("books")
    val books: List<BookVO>?,

    @SerializedName("book_details")
    val bookDetail: List<BookVO>?,
)
