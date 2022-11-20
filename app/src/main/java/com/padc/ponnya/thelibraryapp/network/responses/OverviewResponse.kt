package com.padc.ponnya.thelibraryapp.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.ponnya.thelibraryapp.data.vos.ResultVO

data class OverviewResponse(

    @SerializedName("results")
    val results: ResultVO?
)
