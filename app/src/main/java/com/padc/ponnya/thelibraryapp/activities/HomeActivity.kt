package com.padc.ponnya.thelibraryapp.activities


import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.adapters.BooksByCategoryAdapter
import com.padc.ponnya.thelibraryapp.adapters.ReadingBooksAdapter
import com.padc.ponnya.thelibraryapp.databinding.ActivityHomeBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomePresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.HomePresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.HomeView
import kotlin.math.abs

class HomeActivity : BaseActivity(), HomeView {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var mBooksByCategoryAdapter: BooksByCategoryAdapter
    private lateinit var mHomePresenter: HomePresenter
    private lateinit var mReadingBooksAdapter: ReadingBooksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpPresenter()

        setUpVisaCardViewPager2()
        setUpRecyclerView()
        setUpListener()
    }

    private fun setUpPresenter() {
        mHomePresenter = ViewModelProvider(this)[HomePresenterImpl::class.java]
        mHomePresenter.initView(this)
    }

    private fun setUpVisaCardViewPager2() {
        mReadingBooksAdapter = ReadingBooksAdapter(mHomePresenter)
        binding.viewPagerReadingBook.adapter = mReadingBooksAdapter
        binding.viewPagerReadingBook.clipToPadding = false
        binding.viewPagerReadingBook.clipChildren = false
        binding.viewPagerReadingBook.offscreenPageLimit = 3
        binding.viewPagerReadingBook.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        binding.viewPagerReadingBook.setPageTransformer(compositePageTransformer)

    }

    private fun setUpRecyclerView() {
        mBooksByCategoryAdapter = BooksByCategoryAdapter(mHomePresenter, mHomePresenter)
        binding.rvBooksByCategory.adapter = mBooksByCategoryAdapter
        binding.rvBooksByCategory.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpListener() {
        //Close Option Menu
        binding.viewOptionMenu.view.setOnClickListener { mHomePresenter.onTapOptionMenuScreen() }
    }

    override fun openMoreBookScreen() {
        startActivity(MoreBooksActivity.newIntent(this))
    }

    override fun openBookOptionMenu() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorTransparentOverlay)
        binding.viewOptionMenu.root.visibility = View.VISIBLE

    }

    override fun closeBookOptionMenu() {
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        binding.viewOptionMenu.root.visibility = View.INVISIBLE
    }

}