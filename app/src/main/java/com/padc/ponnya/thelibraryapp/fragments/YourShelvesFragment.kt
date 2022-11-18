package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.activities.ShelfActivity
import com.padc.ponnya.thelibraryapp.adapters.ShelvesAdapter
import com.padc.ponnya.thelibraryapp.databinding.FragmentYourShelvesBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.YourShelvesFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.YourShelvesFragmentPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.YourShelvesFragmentView

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
    }

    override fun navigateToShelfScreen() {
        startActivity(context?.let { ShelfActivity.newIntent(it) })
    }

}