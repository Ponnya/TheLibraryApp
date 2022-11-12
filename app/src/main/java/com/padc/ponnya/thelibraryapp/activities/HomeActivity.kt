package com.padc.ponnya.thelibraryapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.padc.ponnya.thelibraryapp.adapters.BooksByCategoryAdapter
import com.padc.ponnya.thelibraryapp.adapters.ReadingBooksAdapter
import com.padc.ponnya.thelibraryapp.databinding.ActivityHomeBinding
import kotlin.math.abs

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var mBooksByCategoryAdapter: BooksByCategoryAdapter

    private lateinit var mReadingBooksAdapter: ReadingBooksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpVisaCardViewPager2()
        setUpRecyclerView()
        binding.layoutSearchBar.ivProfile.setOnClickListener {
            startActivity(MoreBooksActivity.newIntent(this))
        }
    }

    private fun setUpVisaCardViewPager2() {
        mReadingBooksAdapter = ReadingBooksAdapter()
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
        mBooksByCategoryAdapter = BooksByCategoryAdapter()
        binding.rvBooksByCategory.adapter = mBooksByCategoryAdapter
        binding.rvBooksByCategory.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

}