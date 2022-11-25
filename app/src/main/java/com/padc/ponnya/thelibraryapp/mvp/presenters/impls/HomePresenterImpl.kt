package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomePresenter
import com.padc.ponnya.thelibraryapp.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter {
    private lateinit var mView: HomeView
    private val mModel: NYTimeModel = NYTimeModelImpl
    override fun initView(view: HomeView) {
        mView = view
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onUiReady(owner: LifecycleOwner) {
    }


}