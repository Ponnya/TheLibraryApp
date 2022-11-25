package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.activities.CreateShelfActivity
import com.padc.ponnya.thelibraryapp.activities.ShelfActivity
import com.padc.ponnya.thelibraryapp.adapters.ShelvesAdapter
import com.padc.ponnya.thelibraryapp.data.vos.ShelfVO
import com.padc.ponnya.thelibraryapp.databinding.FragmentYourShelvesBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.YourShelvesFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.YourShelvesFragmentPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.YourShelvesFragmentView
import com.padc.ponnya.thelibraryapp.utils.YOUR_SHELVES

class YourShelvesFragment : Fragment(), YourShelvesFragmentView {

    private lateinit var binding: FragmentYourShelvesBinding

    private lateinit var shelvesAdapter: ShelvesAdapter
    private lateinit var mPresenter: YourShelvesFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYourShelvesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()

        setUpRecyclerView()
        setUpListener()

        mPresenter.onUiReady(this)

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourShelvesFragmentPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpRecyclerView() {
        shelvesAdapter = ShelvesAdapter(mPresenter)
        binding.rvShelves.adapter = shelvesAdapter
        binding.rvShelves.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvShelves.visibility = View.GONE
    }

    private fun setUpListener() {
        binding.btnCreateNewShelf.setOnClickListener {
            mPresenter.onTapCreateNew()
        }
    }

    override fun navigateToShelfScreen(shelfID: Int) {
        startActivity(context?.let { ShelfActivity.newIntent(it, shelfID) })
    }

    override fun showShelves(shelves: List<ShelfVO>) {
        if (shelves.isNotEmpty()) {
            binding.rvShelves.visibility = View.VISIBLE
            binding.rlNoShelves.visibility = View.GONE
            shelvesAdapter.setNewData(shelves, YOUR_SHELVES)
        } else {
            binding.rvShelves.visibility = View.GONE
            binding.rlNoShelves.visibility = View.VISIBLE
        }
    }

    override fun openCreateNewShelfScreen() {
        resultLauncher.launch(context?.let { CreateShelfActivity.newIntent(it) })
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

}