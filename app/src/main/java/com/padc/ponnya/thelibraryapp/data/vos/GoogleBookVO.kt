package com.padc.ponnya.thelibraryapp.data.vos

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("volumeInfo") val volumeInfo: GoogleBookVO?
)

data class GoogleBookVO(
    @SerializedName("title") val title: String?,

    @SerializedName("authors") val authors: List<String>?,

    @SerializedName("description") val description: String?,

    @SerializedName("pageCount") val pageCount: Int?,

    @SerializedName("categories") val categories: List<String>?,

    @SerializedName("imageLinks") val imageLinks: Image?

) {
    fun convertToBookVO(): BookVO {
        println(imageLinks)
        return BookVO(
            bookImage = imageLinks?.changeHttpToHttps(),
            author = authors?.first(),
            createdDate = null,
            description = description,
            price = null,
            bookTitle = title ?: "",
            listName = categories,
            updatedDate = null,
            pageCount = pageCount ?: 0
        )
    }
}

data class Image(
    @SerializedName("smallThumbnail") val smallThumbnail: String?,
) {
    fun changeHttpToHttps() =
        smallThumbnail?.replaceRange(4, 4, "s")

}
