package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.padc.ponnya.thelibraryapp.activities.DetailActivity
import com.padc.ponnya.thelibraryapp.databinding.FragmentLibraryBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.LibraryFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.LibraryFragmentPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView
import com.padc.ponnya.thelibraryapp.utils.LARGE_GIRD
import com.padc.ponnya.thelibraryapp.utils.LIST
import com.padc.ponnya.thelibraryapp.utils.SMALL_GIRD

class LibraryFragment : Fragment(), LibraryFragmentView {

    private lateinit var binding: FragmentLibraryBinding
    private lateinit var mPresenter: LibraryFragmentPresenter
    private lateinit var viewAsFragment: ViewAsFragment

    private var mCheckedRadioButton = LIST

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpViewPod()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[LibraryFragmentPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPod() {
        binding.viewPodDisplayBook.setUpRecyclerView(mPresenter, mPresenter)
        binding.viewPodDisplayBook.setUpDelegate(mPresenter)
    }

    override fun tapOnChip(position: Int) {
        binding.viewPodDisplayBook.clickOnChip(position)
    }

    override fun showSortByFragment() {
        SortByFragment().show(childFragmentManager, null)
    }

    override fun showViewAsFragment() {
        viewAsFragment = ViewAsFragment()
        viewAsFragment.show(childFragmentManager, null)
        viewAsFragment.setUpViewAsFragment(mPresenter, mCheckedRadioButton)
    }

    override fun openBookOptionMenu() {
        CarouselOptionMenuFragment().show(childFragmentManager, null)
    }

    override fun changeListView() {
        binding.viewPodDisplayBook.showListView()
        mCheckedRadioButton = LIST
    }

    override fun changeLargeGridView() {
        binding.viewPodDisplayBook.showLargeGridView()
        mCheckedRadioButton = LARGE_GIRD
    }

    override fun changeSmallGridView() {
        binding.viewPodDisplayBook.showSmallGridView()
        mCheckedRadioButton = SMALL_GIRD
    }

    override fun navigateToDetailScreen() {
        startActivity(context?.let { DetailActivity.newIntent(it) })
    }


}