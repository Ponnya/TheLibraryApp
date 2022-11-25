package com.padc.ponnya.thelibraryapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.adapters.BookListAdapter
import com.padc.ponnya.thelibraryapp.adapters.ChipAdapter
import com.padc.ponnya.thelibraryapp.adapters.MoreEbooksAdapter
import com.padc.ponnya.thelibraryapp.adapters.SmallEbookAdapter
import com.padc.ponnya.thelibraryapp.data.vos.BookVO
import com.padc.ponnya.thelibraryapp.databinding.ViewPodBookDisplayAndSortingBinding
import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuAndDetailDelegate
import com.padc.ponnya.thelibraryapp.delegates.SortByDelegate
import com.padc.ponnya.thelibraryapp.delegates.ViewAsDelegate
import com.padc.ponnya.thelibraryapp.fragments.SortByFragment
import com.padc.ponnya.thelibraryapp.fragments.ViewAsFragment
import com.padc.ponnya.thelibraryapp.utils.AUTHOR
import com.padc.ponnya.thelibraryapp.utils.RECENTLY_OPENED
import com.padc.ponnya.thelibraryapp.utils.TITLE
import com.padc.ponnya.thelibraryapp.views.viewholders.ListData

class BookDisplayAndSortingViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private var binding: ViewPodBookDisplayAndSortingBinding

    private var mListData: List<ListData> = listOf()
    private var mBookList: List<BookVO> = listOf()

    private lateinit var mChipDelegate: ChipDelegate

    private lateinit var chipAdapter: ChipAdapter
    private lateinit var bookListAdapter: BookListAdapter
    private lateinit var smallEbookAdapter: SmallEbookAdapter
    private lateinit var moreEbooksAdapter: MoreEbooksAdapter
    private lateinit var viewAsFragment: ViewAsFragment
    private lateinit var sortByFragment: SortByFragment

    private lateinit var mDelegate: Delegate

    init {
        binding =
            ViewPodBookDisplayAndSortingBinding.inflate(LayoutInflater.from(context), this, true)
    }


    override fun onFinishInflate() {
        super.onFinishInflate()

        setUpListener()

    }

    private fun setUpListener() {

        //SortBy
        binding.btnSortBy.setOnClickListener {
            mDelegate.onTapBtnSortBy()
        }

        //ViewAs
        binding.btnViewAs.setOnClickListener {
            mDelegate.onTapBtnViewAs()
        }

        binding.btnClearGenre.setOnClickListener {
            mListData.forEach {
                it.isSelected = false
            }
            binding.btnClearGenre.visibility = GONE

            setNewDataToAdapter()

        }
    }

    private fun checkChip(): List<BookVO> {
        mListData.filter { it.isSelected }.let {

            if (it.isNotEmpty()) {
                val data = it.map { listData -> listData.listName }
                val selectedData: MutableList<BookVO> = mutableListOf()
                mBookList.filter { mBookList ->
                    mBookList.listName?.containsAll(data) ?: false
                }.toMutableList().forEach { bookVO ->
                    selectedData.add(bookVO)
                }

                //chipRecyclerView
                chipAdapter.setNewData(resetChip(selectedData))

                return selectedData

            } else {

                //chipRecyclerView
                chipAdapter.setNewData(mListData)

                return mBookList
            }
        }
    }

    private fun resetChip(bookList: List<BookVO>): List<ListData> {
        //chipRecyclerView
        val chip: MutableSet<ListData> = mutableSetOf()
        if (mListData.isEmpty()) {
            bookList.forEach {
                it.listName?.forEach { listName ->
                    if (listName != null) {
                        chip.add(ListData(listName))
                    }
                }
            }
        } else {
            bookList.forEach {
                it.listName?.forEach { listName ->
                    if (listName != null) {
                        chip.add(mListData.first { data -> data.listName == listName })
                    }
                }
            }
        }

        return chip.toList()
    }

    private fun setNewDataToAdapter() {
        val bookList = checkChip()

        //listGrid
        bookListAdapter.setNewData(bookList)

        //largeGrid
        moreEbooksAdapter.setNewData(bookList)

        //smallGrid
        smallEbookAdapter.setNewData(bookList)
    }

    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun setUpRecyclerView(
        chipDelegate: ChipDelegate, optionMenuDelegate: OptionMenuAndDetailDelegate
    ) {
        //ChipRecyclerView
        mChipDelegate = chipDelegate
        chipAdapter = ChipAdapter(mChipDelegate)
        binding.rvBookGenre.adapter = chipAdapter
        binding.rvBookGenre.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        //ListRecyclerView
        bookListAdapter = BookListAdapter(optionMenuDelegate)
        binding.rvDisplayBookList.adapter = bookListAdapter
        binding.rvDisplayBookList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvDisplayBookList.visibility = VISIBLE

        //LargeGridRecyclerView
        moreEbooksAdapter = MoreEbooksAdapter(optionMenuDelegate)
        binding.rvDisplayBookLargeGrid.adapter = moreEbooksAdapter
        binding.rvDisplayBookLargeGrid.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.rvDisplayBookLargeGrid.visibility = GONE

        //SmallGridRecyclerView
        smallEbookAdapter = SmallEbookAdapter(optionMenuDelegate)
        binding.rvDisplayBookSmallGrid.adapter = smallEbookAdapter
        binding.rvDisplayBookSmallGrid.layoutManager =
            GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        binding.rvDisplayBookSmallGrid.visibility = GONE


    }

    fun setData(bookList: List<BookVO>) {
        mListData = resetChip(bookList)
        mBookList = bookList.sortedBy { it.updatedDate }
        setNewDataToAdapter()

    }


    fun clickOnChip(listData: ListData) {
        mListData.forEach {
            if (it.listName == listData.listName) {
                it.isSelected = !it.isSelected
            }
        }

        if (mListData.any { it.isSelected }) {
            binding.btnClearGenre.visibility = VISIBLE
        } else {
            binding.btnClearGenre.visibility = GONE
        }

        setNewDataToAdapter()
    }

    fun showListView() {
        binding.rvDisplayBookList.visibility = VISIBLE
        binding.rvDisplayBookLargeGrid.visibility = GONE
        binding.rvDisplayBookSmallGrid.visibility = GONE
    }

    fun showLargeGridView() {
        binding.rvDisplayBookList.visibility = GONE
        binding.rvDisplayBookLargeGrid.visibility = VISIBLE
        binding.rvDisplayBookSmallGrid.visibility = GONE
    }

    fun showSmallGridView() {
        binding.rvDisplayBookList.visibility = GONE
        binding.rvDisplayBookLargeGrid.visibility = GONE
        binding.rvDisplayBookSmallGrid.visibility = VISIBLE
    }

    fun sorting(checkedRadioButton: String) {
        when (checkedRadioButton) {
            RECENTLY_OPENED -> mBookList = mBookList.sortedBy { it.updatedDate }
            TITLE -> mBookList = mBookList.sortedBy { it.bookTitle }
            AUTHOR -> mBookList = mBookList.sortedBy { it.author }
        }

        binding.tvSortBy.text = when (checkedRadioButton) {
            RECENTLY_OPENED -> "Recent"
            TITLE -> "Title"
            else -> "Author"
        }
        setNewDataToAdapter()
    }

    fun showSortByFragment(
        fragmentManager: FragmentManager,
        delegate: SortByDelegate,
        checkedRadioButton: String
    ) {
        sortByFragment = SortByFragment()
        sortByFragment.show(fragmentManager, null)
        sortByFragment.setUpSortByFragment(delegate, checkedRadioButton)
    }

    fun showViewAsFragment(
        fragmentManager: FragmentManager, delegate: ViewAsDelegate, checkedRadioButton: String
    ) {
        viewAsFragment = ViewAsFragment()
        viewAsFragment.show(fragmentManager, null)
        viewAsFragment.setUpViewAsFragment(delegate, checkedRadioButton)
    }

    interface Delegate {
        fun onTapBtnSortBy()
        fun onTapBtnViewAs()
    }

}