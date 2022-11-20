package com.padc.ponnya.thelibraryapp.network

import com.padc.ponnya.thelibraryapp.network.responses.OverviewResponse
import com.padc.ponnya.thelibraryapp.utils.API_OVERVIEW
import com.padc.ponnya.thelibraryapp.utils.NYTIMES_API_KEY
import com.padc.ponnya.thelibraryapp.utils.PARAM_API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimeApi {

    @GET(API_OVERVIEW)
    fun getOverview(
        @Query(PARAM_API_KEY) apiKey: String = NYTIMES_API_KEY,
    ): Observable<OverviewResponse>
}