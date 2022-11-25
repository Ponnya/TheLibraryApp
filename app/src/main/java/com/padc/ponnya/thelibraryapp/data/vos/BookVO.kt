package com.padc.ponnya.thelibraryapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padc.ponnya.thelibraryapp.persistence.typeconverters.ListNameTypeConverter

@Entity(tableName = "books")
@TypeConverters(
    ListNameTypeConverter::class,
)
data class BookVO(

    @SerializedName("book_image")
    @ColumnInfo(name = "book_image")
    val bookImage: String?,

    @SerializedName("author")
    @ColumnInfo(name = "author")
    val author: String?,

    @SerializedName("created_date")
    @ColumnInfo(name = "created_date")
    val createdDate: String?,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String?,

    @SerializedName("price")
    @ColumnInfo(name = "price")
    val price: String?,

    @SerializedName("title")
    @PrimaryKey
    val bookTitle: String,

    @ColumnInfo(name = "list_name")
    val listName: List<String?>?,

    @SerializedName("updated_date")
    @ColumnInfo(name = "updated_date")
    val updatedDate: String?,
)
