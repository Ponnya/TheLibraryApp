package com.padc.ponnya.thelibraryapp.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO
import com.padc.ponnya.thelibraryapp.data.vos.ResultVO

data class ListResponse(
    @SerializedName("results")
    val results: List<CategoryVO>?
)