package com.padc.ponnya.thelibraryapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.adapters.BookListAdapter
import com.padc.ponnya.thelibraryapp.adapters.ChipAdapter
import com.padc.ponnya.thelibraryapp.adapters.MoreEbooksAdapter
import com.padc.ponnya.thelibraryapp.adapters.SmallEbookAdapter
import com.padc.ponnya.thelibraryapp.databinding.ViewPodBookDisplayAndSortingBinding
import com.padc.ponnya.thelibraryapp.delegates.ChipDelegate
import com.padc.ponnya.thelibraryapp.delegates.OptionMenuDelegate
import com.padc.ponnya.thelibraryapp.views.viewholders.DummyClass

class BookDisplayAndSortingViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private lateinit var binding: ViewPodBookDisplayAndSortingBinding

    private val data = listOf(DummyClass(false), DummyClass(false), DummyClass(), DummyClass())

    private lateinit var mChipDelegate: ChipDelegate

    private lateinit var chipAdapter: ChipAdapter
    private lateinit var bookListAdapter: BookListAdapter
    private lateinit var smallEbookAdapter: SmallEbookAdapter
    private lateinit var moreEbooksAdapter: MoreEbooksAdapter

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
    }


    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun setUpRecyclerView(chipDelegate: ChipDelegate, optionMenuDelegate: OptionMenuDelegate) {
        //ChipRecyclerView
        mChipDelegate = chipDelegate
        chipAdapter = ChipAdapter(mChipDelegate)
        binding.rvBookGenre.adapter = chipAdapter
        binding.rvBookGenre.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        chipAdapter.setNewData(data)

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


    fun clickOnChip(position: Int) {
        data[position].apply { isSelected = !isSelected }
        chipAdapter.setNewData(data)
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


    interface Delegate {
        fun onTapBtnSortBy()
        fun onTapBtnViewAs()
    }

}