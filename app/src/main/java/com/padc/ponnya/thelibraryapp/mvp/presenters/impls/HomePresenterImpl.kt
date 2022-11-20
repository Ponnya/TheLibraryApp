package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomePresenter

class HomePresenterImpl : ViewModel(), HomePresenter {
    private val mModel: NYTimeModel = NYTimeModelImpl
    override fun onUiReady(owner: LifecycleOwner) {

    }
}