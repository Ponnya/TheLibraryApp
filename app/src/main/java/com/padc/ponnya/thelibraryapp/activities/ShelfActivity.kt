package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import com.padc.ponnya.thelibraryapp.databinding.ActivityShelfBinding
import com.padc.ponnya.thelibraryapp.fragments.CarouselOptionMenuFragment
import com.padc.ponnya.thelibraryapp.fragments.ShelfOptionMenuFragment
import com.padc.ponnya.thelibraryapp.mvp.presenters.ShelfPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.ShelfPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.ShelfView
import com.padc.ponnya.thelibraryapp.utils.LARGE_GIRD
import com.padc.ponnya.thelibraryapp.utils.LIST
import com.padc.ponnya.thelibraryapp.utils.SMALL_GIRD

class ShelfActivity : BaseActivity(), ShelfView {
    private lateinit var binding: ActivityShelfBinding
    private lateinit var mPresenter: ShelfPresenter

    private var mCheckedRadioButton = LIST


    companion object {
        fun newIntent(context: Context) = Intent(context, ShelfActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShelfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
        setUpViewPod()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ShelfPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPod() {
        binding.viewPodDisplayBook.setUpRecyclerView(mPresenter, mPresenter)
        binding.viewPodDisplayBook.setUpDelegate(mPresenter)
    }

    private fun setUpListener() {
        binding.btnOptionShelf.setOnClickListener {
            ShelfOptionMenuFragment().apply {
                show(supportFragmentManager, null)
                setUpDelegate(mPresenter)
            }
        }

        binding.edtCreateShelf.setOnEditorActionListener { view, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                binding.tvShelfTitle.text = view.text
                binding.tvShelfTitle.visibility = View.VISIBLE
                binding.textInputLayout.visibility = View.GONE

            }
            false
        }

    }

    override fun tapOnChip(position: Int) {
        binding.viewPodDisplayBook.clickOnChip(position)
    }

    override fun showSortByFragment() {
        binding.viewPodDisplayBook.showSortByFragment(supportFragmentManager)
    }

    override fun showViewAsFragment() {
        binding.viewPodDisplayBook.showViewAsFragment(
            supportFragmentManager, mPresenter, mCheckedRadioButton
        )
    }

    override fun openBookOptionMenu() {
        CarouselOptionMenuFragment().show(supportFragmentManager, null)
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
        startActivity(DetailActivity.newIntent(this))
    }

    override fun renameShelf() {
        binding.tvShelfTitle.visibility = View.GONE
        binding.textInputLayout.visibility = View.VISIBLE

        binding.edtCreateShelf.requestFocus()
        val inputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.edtCreateShelf, InputMethodManager.SHOW_IMPLICIT)
        setUpListener()

    }

    override fun deleteShelf() {
    }

}