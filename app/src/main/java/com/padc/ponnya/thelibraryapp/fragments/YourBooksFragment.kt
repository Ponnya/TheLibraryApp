package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.padc.ponnya.thelibraryapp.activities.DetailActivity
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.FragmentYourBooksBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.YourBooksFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.YourBooksFragmentPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.YourBooksFragmentView
import com.padc.ponnya.thelibraryapp.utils.*
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData


class YourBooksFragment : Fragment(), YourBooksFragmentView {


    private lateinit var binding: FragmentYourBooksBinding
    private lateinit var mPresenter: YourBooksFragmentPresenter


    private var mCheckedRadioButtonViewAs = LIST
    private var mCheckedRadioButtonSortBy = RECENTLY_OPENED

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYourBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourBooksFragmentPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPod() {
        binding.viewPodDisplayBook.setUpRecyclerView(mPresenter, mPresenter)
        binding.viewPodDisplayBook.setUpDelegate(mPresenter)
    }

    override fun showBooks(bookList: List<BookVO>) {
        binding.viewPodDisplayBook.setData(bookList)
    }


    override fun tapOnChip(listData: ListData) {
        binding.viewPodDisplayBook.clickOnChip(listData)
    }

    override fun showSortByFragment() {
        binding.viewPodDisplayBook.showSortByFragment(
            childFragmentManager,
            mPresenter,
            mCheckedRadioButtonSortBy
        )
    }

    override fun showViewAsFragment() {
        binding.viewPodDisplayBook.showViewAsFragment(
            childFragmentManager,
            mPresenter,
            mCheckedRadioButtonViewAs
        )
    }

    override fun openBookOptionMenu() {
        CarouselOptionMenuFragment().show(childFragmentManager, null)
    }

    override fun changeListView() {
        binding.viewPodDisplayBook.showListView()
        mCheckedRadioButtonViewAs = LIST
    }

    override fun changeLargeGridView() {
        binding.viewPodDisplayBook.showLargeGridView()
        mCheckedRadioButtonViewAs = LARGE_GIRD
    }

    override fun changeSmallGridView() {
        binding.viewPodDisplayBook.showSmallGridView()
        mCheckedRadioButtonViewAs = SMALL_GIRD
    }

    override fun navigateToDetailScreen() {
        startActivity(context?.let { DetailActivity.newIntent(it) })
    }

    override fun sortByRecentlyOpened() {
        binding.viewPodDisplayBook.sorting(RECENTLY_OPENED)
        mCheckedRadioButtonSortBy = RECENTLY_OPENED
    }

    override fun sortByTitle() {
        binding.viewPodDisplayBook.sorting(TITLE)
        mCheckedRadioButtonSortBy = TITLE
    }

    override fun sortByAuthor() {
        binding.viewPodDisplayBook.sorting(AUTHOR)
        mCheckedRadioButtonSortBy = AUTHOR
    }


}