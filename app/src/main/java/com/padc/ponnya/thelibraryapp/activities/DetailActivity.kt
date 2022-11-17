package com.padc.ponnya.thelibraryapp.activities

import android.animation.AnimatorInflater
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.adapters.CommentAdapter
import com.padc.ponnya.thelibraryapp.databinding.ActivityDetailBinding
import com.padc.ponnya.thelibraryapp.utils.SCROLL_Y_POSITION

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var mCommentAdapter: CommentAdapter

    companion object {
        fun newIntent(context: Context) = Intent(context, DetailActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        setUpScrollListener()
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
}