package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.databinding.ActivityShelfBinding
import com.padc.ponnya.thelibraryapp.fragments.OptionMenuFragment
import com.padc.ponnya.thelibraryapp.fragments.ShelfOptionMenuFragment
import com.padc.ponnya.thelibraryapp.mvp.presenters.ShelfPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.ShelfPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.ShelfView
import com.padc.ponnya.thelibraryapp.utils.*
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

class ShelfActivity : BaseActivity(), ShelfView {
    private lateinit var binding: ActivityShelfBinding
    private lateinit var mPresenter: ShelfPresenter

    private var mCheckedRadioButtonViewAs = LIST
    private var mCheckedRadioButtonSortBy = RECENTLY_OPENED

    private var mShelfVO: ShelfVO? = null

    private lateinit var optionMenuFragment: OptionMenuFragment

    companion object {
        private const val SHELF_ID = "SHELF_ID"
        fun newIntent(context: Context, shelfId: Int) =
            Intent(context, ShelfActivity::class.java).putExtra(
                SHELF_ID,
                shelfId
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShelfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
        setUpViewPod()
        setUpListener()
        val shelfId = intent?.getIntExtra(SHELF_ID, -1)

        if (shelfId != null && shelfId != -1) {
            mPresenter.onUIReady(this, shelfId)
        }

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
            mPresenter.onTapShelfOptionMenu()
        }

        binding.edtCreateShelf.setOnEditorActionListener { view, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                binding.tvShelfTitle.visibility = View.VISIBLE
                binding.textInputLayout.visibility = View.GONE
                if (!view.text.isNullOrBlank()) {
                    mShelfVO?.let { mPresenter.onTapDoneButton(it.copy(shelfName = view.text.toString())) }
                }
            }
            false
        }

        binding.btnBackShelf.setOnClickListener {
            mPresenter.onTapBack()
        }

    }

    override fun showShelfTitleAndBookCount(shelfVO: ShelfVO) {
        mShelfVO = shelfVO
        binding.tvShelfTitle.text = shelfVO.shelfName
        binding.tvBookCount.text = when (shelfVO.bookCount) {
            0, 1 -> "${shelfVO.bookCount} book"
            else -> "${shelfVO.bookCount} books"
        }
    }

    override fun showBooks(bookList: List<BookVO>) {
        binding.viewPodDisplayBook.setData(bookList)
    }

    override fun tapOnChip(listData: ListData) {
        binding.viewPodDisplayBook.clickOnChip(listData)
    }

    override fun showSortByFragment() {
        binding.viewPodDisplayBook.showSortByFragment(
            supportFragmentManager,
            mPresenter,
            mCheckedRadioButtonSortBy
        )
    }

    override fun showViewAsFragment() {
        binding.viewPodDisplayBook.showViewAsFragment(
            supportFragmentManager, mPresenter, mCheckedRadioButtonViewAs
        )
    }

    override fun openBookOptionMenu(bookVO: BookVO) {
        optionMenuFragment = OptionMenuFragment()
        optionMenuFragment.show(supportFragmentManager, null)
        optionMenuFragment.setUpOptionMenuFragment(bookVO)
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

    override fun navigateToDetailScreen(bookTitle: String) {
        startActivity(DetailActivity.newIntent(this, bookTitle))
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


    override fun renameShelf() {
        binding.tvShelfTitle.visibility = View.GONE
        binding.textInputLayout.visibility = View.VISIBLE

        binding.edtCreateShelf.requestFocus()
        val inputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.edtCreateShelf, InputMethodManager.SHOW_IMPLICIT)


    }

    override fun openShelfOptionMenu() {
        ShelfOptionMenuFragment().apply {
            show(supportFragmentManager, null)
            setUpDelegate(mPresenter)
        }
    }

    override fun navigateToHomeScreen() {
        finish()
    }

}