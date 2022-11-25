package com.padc.ponnya.thelibraryapp.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.ponnya.thelibraryapp.data.vos.Items

data class GoogleBookSearchResponse(
    @SerializedName("items") val items: List<Items>?,
)
