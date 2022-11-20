package com.padc.ponnya.thelibraryapp

import android.app.Application
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl

class TheLibraryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NYTimeModelImpl.initDatabase(applicationContext)
    }
}