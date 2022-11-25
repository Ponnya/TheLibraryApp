package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.padc.ponnya.thelibraryapp.activities.AddToShelvesActivity
import com.padc.ponnya.thelibraryapp.activities.DetailActivity
import com.padc.ponnya.thelibraryapp.activities.MoreBooksActivity
import com.padc.ponnya.thelibraryapp.adapters.BooksByCategoryAdapter
import com.padc.ponnya.thelibraryapp.adapters.ReadingBooksAdapter
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.CategoryVO
import com.padc.ponnya.thelibraryapp.databinding.FragmentHomeBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomeFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.HomeFragmentPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.HomeFragmentView
import kotlin.math.abs

class HomeFragment : BaseFragment(), HomeFragmentView {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var mBooksByCategoryAdapter: BooksByCategoryAdapter
    private lateinit var mReadingBooksAdapter: ReadingBooksAdapter

    private lateinit var mPresenter: HomeFragmentPresenter

    private lateinit var carouselOptionMenuFragment: CarouselOptionMenuFragment
    private lateinit var optionMenuFragment: OptionMenuFragment

    private val homeFragmentVM: HomeFragmentPresenterImpl by lazy {
        ViewModelProvider(this)[HomeFragmentPresenterImpl::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()

        setUpVisaCardViewPager2()
        setUpRecyclerView()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = homeFragmentVM
        mPresenter.initView(this)
    }


    private fun setUpVisaCardViewPager2() {
        mReadingBooksAdapter = ReadingBooksAdapter(mPresenter)
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
        mBooksByCategoryAdapter = BooksByCategoryAdapter(mPresenter, mPresenter)
        binding.rvBooksByCategory.adapter = mBooksByCategoryAdapter
        binding.rvBooksByCategory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun showCategoryAndBook(categoryList: List<CategoryVO>) {
        mBooksByCategoryAdapter.setNewData(categoryList)
    }

    override fun showReadingBook(bookList: List<BookVO>) {
        if (bookList.isNotEmpty()) {
            mReadingBooksAdapter.setNewData(bookList)
            binding.frameLayoutReadingBook.visibility = View.VISIBLE
            binding.relativeLayoutNullReadingBook.visibility = View.GONE
        } else {
            binding.frameLayoutReadingBook.visibility = View.GONE
            binding.relativeLayoutNullReadingBook.visibility = View.VISIBLE
        }
    }

    override fun openMoreBookScreen(list: String) {
        startActivity(context?.let { MoreBooksActivity.newIntent(it, list) })
    }

    override fun openBookCarouselOptionMenu(bookVO: BookVO) {
        carouselOptionMenuFragment = CarouselOptionMenuFragment()
        carouselOptionMenuFragment.show(childFragmentManager, null)
        carouselOptionMenuFragment.setUpCarouselOptionMenuFragment(mPresenter, bookVO)

    }

    override fun openBookOptionMenu(bookVO: BookVO) {
        optionMenuFragment = OptionMenuFragment()
        optionMenuFragment.show(childFragmentManager, null)
        optionMenuFragment.setUpOptionMenuFragment(bookVO)

    }

    override fun navigateToDetail(bookTile: String) {
        startActivity(context?.let { DetailActivity.newIntent(it, bookTile) })
    }

    override fun openAddToShelvesScreen(bookTile: String) {
        resultLauncher.launch(context?.let { AddToShelvesActivity.newIntent(it, bookTile) })
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

}