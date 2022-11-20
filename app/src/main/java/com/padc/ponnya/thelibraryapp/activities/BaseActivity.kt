package com.padc.ponnya.thelibraryapp.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.padc.ponnya.thelibraryapp.mvp.views.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun showError(errorString: String) {
        Snackbar.make(window.decorView, errorString, Snackbar.LENGTH_SHORT).show()
    }

}