package com.padc.ponnya.thelibraryapp.network

import com.padc.ponnya.thelibraryapp.network.responses.GoogleBookSearchResponse
import com.padc.ponnya.thelibraryapp.network.responses.ListResponse
import com.padc.ponnya.thelibraryapp.network.responses.OverviewResponse
import com.padc.ponnya.thelibraryapp.utils.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NYTimeApi {

    @GET(API_OVERVIEW)
    fun getOverview(
        @Query(PARAM_API_KEY) apiKey: String = NYTIMES_API_KEY,
    ): Observable<OverviewResponse>

    @GET(API_LIST)
    fun getList(
        @Query(PARAM_API_KEY) apiKey: String = NYTIMES_API_KEY,
        @Query(PARAM_LIST) list: String,
    ): Observable<ListResponse>

    @GET
    fun searchBooks(
        @Url url: String = API_GOOGLE_SEARCH_BOOK,
        @Query(PARAM_Q) q: String,
    ): Observable<GoogleBookSearchResponse>
}