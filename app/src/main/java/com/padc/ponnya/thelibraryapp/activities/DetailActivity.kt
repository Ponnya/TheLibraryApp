package com.padc.ponnya.thelibraryapp.activities

import android.animation.AnimatorInflater
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.adapters.CommentAdapter
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ActivityDetailBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.DetailPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.DetailPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.DetailView
import com.padc.ponnya.thelibraryapp.utils.SCROLL_Y_POSITION

class DetailActivity : BaseActivity(), DetailView {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var mPresenter: DetailPresenter
    private lateinit var mCommentAdapter: CommentAdapter

    companion object {
        private const val BOOK_TITLE = "BOOK_TITLE"
        fun newIntent(context: Context, bookTitle: String) =
            Intent(context, DetailActivity::class.java).putExtra(
                BOOK_TITLE, bookTitle
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()

        setUpRecyclerView()
        setUpScrollListener()
        setUpListener()
        val bookTitle = intent.getStringExtra(BOOK_TITLE)
        if (bookTitle != null) {
            mPresenter.onUiReady(this, bookTitle)
        }

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[DetailPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpRecyclerView() {
        mCommentAdapter = CommentAdapter()
        binding.rvComments.adapter = mCommentAdapter
        binding.rvComments.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpScrollListener() {

        binding.scrollViewDetail.setOnScrollChangeListener { _: View, _: Int, scrollY: Int, _: Int, _: Int ->
            if (scrollY == SCROLL_Y_POSITION) {
                binding.appBarDetail.stateListAnimator =
                    AnimatorInflater.loadStateListAnimator(this, R.animator.appbar_elevation_off)
            } else {
                binding.appBarDetail.stateListAnimator =
                    AnimatorInflater.loadStateListAnimator(this, R.animator.appbar_elevation_on)
            }
        }

    }

    private fun setUpListener() {
        binding.btnBack.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    override fun showBookDetail(bookVO: BookVO) {
        Glide.with(binding.root)
            .load(bookVO.bookImage)
            .into(binding.ivBookCoverDetail)
        binding.tvBookNameDetail.text = bookVO.bookTitle
        binding.tvBookAuthorDetail.text = bookVO.author
        binding.tvAboutThisBook.text = bookVO.description
        binding.tvNumberOfPages.text = bookVO.pageCount.toString()
    }

    override fun endActivity() {
        finish()
    }
}