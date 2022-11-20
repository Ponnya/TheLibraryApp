package com.padc.ponnya.thelibraryapp.data.models

import android.content.Context
import com.padc.ponnya.thelibraryapp.network.NYTimeApi
import com.padc.ponnya.thelibraryapp.persistence.LibraryDatabase
import com.padc.ponnya.thelibraryapp.utils.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mNYTimeApi: NYTimeApi
    protected var mLibraryDatabase: LibraryDatabase? = null

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        mNYTimeApi = retrofit.create(NYTimeApi::class.java)
    }

    fun initDatabase(context: Context) {
        mLibraryDatabase = LibraryDatabase.getDBInstance(context)
    }
}