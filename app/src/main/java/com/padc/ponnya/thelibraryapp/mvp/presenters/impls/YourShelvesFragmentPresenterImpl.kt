package com.padc.ponnya.thelibraryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.padc.ponnya.thelibraryapp.data.models.NYTimeModelImpl
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.mvp.presenters.YourShelvesFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.views.YourShelvesFragmentView

class YourShelvesFragmentPresenterImpl : ViewModel(), YourShelvesFragmentPresenter {
    private lateinit var mView: YourShelvesFragmentView
    private val mModel = NYTimeModelImpl
    override fun initView(view: YourShelvesFragmentView) {
        mView = view
    }

    override fun onTapCreateNew() {
        mView.openCreateNewShelfScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getShelves()?.observe(owner) {

            mView.showShelves(it)

        }
    }

    /**
     * SortByDelegate callback method
     */
    override fun onTapBtnEnterShelf(shelfID: Int) {
        mView.navigateToShelfScreen(shelfID)
    }

    /**
     * SortByDelegate callback method
     */
    override fun onTapCheckBox(shelfVO: ShelfVO?) {
        //Nothing have to do here
    }

    override fun unCheckedCheckBox(shelfVO: ShelfVO?) {
        //Nothing have to do here
    }
}