package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.adapters.MoreEbooksAdapter
import com.padc.ponnya.thelibraryapp.databinding.ActivityMoreBooksBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.MoreBooksPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.MoreBooksPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

class MoreBooksActivity : BaseActivity(), MoreBooksView {
    private lateinit var binding: ActivityMoreBooksBinding
    private lateinit var mMoreEbooksAdapter: MoreEbooksAdapter

    private lateinit var mPresenter: MoreBooksPresenter

    companion object {
        fun newIntent(context: Context) = Intent(context, MoreBooksActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()

        setUpRecyclerView()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MoreBooksPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpRecyclerView() {
        mMoreEbooksAdapter = MoreEbooksAdapter(mPresenter)
        binding.rvMoreBooks.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        binding.rvMoreBooks.adapter = mMoreEbooksAdapter
    }

    private fun setUpListener() {
        //Close Option Menu
        binding.viewOptionMenuMoreBooks.view.setOnClickListener { mPresenter.onTapOptionMenuScreen() }
    }

    override fun openBookOptionMenu() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorTransparentOverlay)
        binding.viewOptionMenuMoreBooks.root.visibility = View.VISIBLE

    }

    override fun closeBookOptionMenu() {
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.viewOptionMenuMoreBooks.root.visibility = View.INVISIBLE
    }
}