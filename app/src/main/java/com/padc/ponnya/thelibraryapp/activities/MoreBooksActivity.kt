package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.padc.ponnya.thelibraryapp.adapters.MoreEbooksAdapter
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ActivityMoreBooksBinding
import com.padc.ponnya.thelibraryapp.fragments.OptionMenuFragment
import com.padc.ponnya.thelibraryapp.mvp.presenters.MoreBooksPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.MoreBooksPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.MoreBooksView

class MoreBooksActivity : BaseActivity(), MoreBooksView {
    private lateinit var binding: ActivityMoreBooksBinding
    private lateinit var mMoreEbooksAdapter: MoreEbooksAdapter

    private lateinit var mPresenter: MoreBooksPresenter
    private lateinit var mList: String

    companion object {
        private const val LIST = "LIST"
        fun newIntent(context: Context, list: String) =
            Intent(context, MoreBooksActivity::class.java).putExtra(
                LIST, list
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()

        setUpRecyclerView()
        setUpListener()

        mList = intent.getStringExtra(LIST) ?: ""
        bindData()
        mPresenter.onUiReady(this, mList)
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
        binding.btnBackToHomeScreen.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    private fun bindData() {
        binding.tvCategory.text = mList
    }

    override fun openBookOptionMenu() {
        OptionMenuFragment().show(supportFragmentManager, null)
    }

    override fun showBookList(bookList: List<BookVO>) {
        mMoreEbooksAdapter.setNewData(bookList)
    }

    override fun navigateToDetailScreen() {
    }

    override fun endActivity() {
       finish()
    }


}