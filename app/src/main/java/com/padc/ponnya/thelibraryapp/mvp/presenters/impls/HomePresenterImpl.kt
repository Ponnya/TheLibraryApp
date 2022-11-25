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
        /*   mModel.createShelf(ShelfVO("Testing Shelf"))

           var shelfId1: Int = -1
           mModel.getShelves()?.observe(owner){
               println("----------------This is Shelves----------------------------")
               println(it)
               shelfId1 = it.first().shelfId
           }

           var bookTitle1: String =""
           mModel.getSavedBook()?.observe(owner){
               println("----------------------------This is saved book------------------------")
               println(it)
               bookTitle1 = it.first().bookTitle
               mModel.addBook( it.first().bookTitle,1)
           }



           mModel.getBooksFormShelf()?.observe(owner){
               println("-------------------------This is Book from shelf---------------------------")
               println(it)
           }*/
    }


}