package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding4.widget.textChanges
import com.padc.ponnya.thelibraryapp.adapters.SearchBookAdapter
import com.padc.ponnya.thelibraryapp.databinding.ActivitySearchBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.SearchPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.SearchPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.SearchView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SearchActivity : BaseActivity(), SearchView {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var mPresenter: SearchPresenter


    companion object {
        fun newIntent(context: Context) = Intent(context, SearchActivity::class.java)
    }

    private lateinit var searchBookAdapter: SearchBookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()

        setUpRecyclerView()

        setUpListener()

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[SearchPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpListener() {
        binding.edtSearch.textChanges()
            .debounce(500L, TimeUnit.MILLISECONDS)
            .flatMap { mPresenter.searchBook(it.toString()) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                searchBookAdapter.setNewData(it)
            }, {
                showError(it.localizedMessage ?: "")
            })

        binding.btnBack.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    private fun setUpRecyclerView() {
        searchBookAdapter = SearchBookAdapter(mPresenter)
        binding.rvSearchBook.adapter = searchBookAdapter
        binding.rvSearchBook.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun navigateToDetail(bookTitle: String) {
        startActivity(DetailActivity.newIntent(this, bookTitle))
    }

    override fun backToHomeScreen() {
        finish()
    }

}