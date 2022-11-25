package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.adapters.ShelvesAdapter
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.databinding.ActivityAddToShelvesBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.AddToShelvesPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.AddToShelvesPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.AddToShelvesView
import com.padc.ponnya.thelibraryapp.utils.ADD_TO_SHELVES

class AddToShelvesActivity : BaseActivity(), AddToShelvesView {
    private lateinit var binding: ActivityAddToShelvesBinding
    private lateinit var mPresenter: AddToShelvesPresenter

    private lateinit var shelvesAdapter: ShelvesAdapter
    private var mBookTitle: String = ""

    companion object {
        private const val BOOK_TITLE = "BOOK_TITLE"
        fun newIntent(context: Context, bookTitle: String) =
            Intent(context, AddToShelvesActivity::class.java).putExtra(
                BOOK_TITLE,
                bookTitle
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToShelvesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
        setUpRecyclerView()
        setUpListener()

        getIntentData()

        mPresenter.onUiReady(this)

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[AddToShelvesPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpRecyclerView() {
        shelvesAdapter = ShelvesAdapter(mPresenter)
        binding.rvShelvesAddTo.adapter = shelvesAdapter
        binding.rvShelvesAddTo.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpListener() {
        binding.btnClose.setOnClickListener {
            mPresenter.onTapCloseButton(mBookTitle)
        }
    }

    private fun getIntentData() {
        mBookTitle = intent?.getStringExtra(BOOK_TITLE).toString()
    }

    override fun showShelves(shelves: List<ShelfVO>) {
        shelvesAdapter.setNewData(shelves, ADD_TO_SHELVES)
    }

    override fun closeAddToShelvesScreen() {
        finish()
    }


}