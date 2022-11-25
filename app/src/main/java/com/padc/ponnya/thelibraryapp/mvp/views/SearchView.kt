package com.padc.ponnya.thelibraryapp.mvp.views

import android.icu.text.CaseMap.Title

interface SearchView: BaseView {
    fun navigateToDetail(bookTitle: String)
    fun backToHomeScreen()
}