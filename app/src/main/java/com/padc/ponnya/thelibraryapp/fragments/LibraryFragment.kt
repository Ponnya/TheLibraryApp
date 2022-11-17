package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.databinding.FragmentLibraryBinding
import com.padc.ponnya.thelibraryapp.mvp.presenters.LibraryFragmentPresenter
import com.padc.ponnya.thelibraryapp.mvp.presenters.impls.LibraryFragmentPresenterImpl
import com.padc.ponnya.thelibraryapp.mvp.views.LibraryFragmentView

class LibraryFragment : Fragment(), LibraryFragmentView {

    private lateinit var binding: FragmentLibraryBinding

    private lateinit var mPresenter: LibraryFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpFragment()
        setUpListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[LibraryFragmentPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpFragment() {
        childFragmentManager.commit {
            add<YourBooksFragment>(R.id.fragmentChildContainer)
        }
    }

    private fun setUpListener() {
        binding.tabLayoutBooksAndShelves.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> mPresenter.onTapYourBooksTab()
                    1 -> mPresenter.onTapYourShelvesTab()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }


    override fun showYourBooksFragment() {
        childFragmentManager.commit {
            replace<YourBooksFragment>(R.id.fragmentChildContainer)
        }
    }

    override fun showYourShelvesFragment() {
        childFragmentManager.commit {
            replace<YourShelvesFragment>(R.id.fragmentChildContainer)
        }
    }


}