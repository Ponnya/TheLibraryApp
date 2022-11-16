package com.padc.ponnya.thelibraryapp.activities


import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.databinding.ActivityHomeBinding
import com.padc.ponnya.thelibraryapp.fragments.HomeFragment
import com.padc.ponnya.thelibraryapp.fragments.LibraryFragment
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomePresenter
import com.padc.ponnya.thelibraryapp.mvp.views.HomeView

class HomeActivity : BaseActivity(), HomeView {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var mHomePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFragment()
        setUpListener()

    }

    private fun setUpFragment() {
        supportFragmentManager.commit {
            add<HomeFragment>(R.id.fragmentContainer)
        }
    }

    private fun setUpListener() {
        binding.bottomNavigationHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuItemHome -> {
                    supportFragmentManager.commit {
                        replace<HomeFragment>(R.id.fragmentContainer)
                    }
                    true
                }
                else -> {
                    supportFragmentManager.commit {
                        replace<LibraryFragment>(R.id.fragmentContainer)
                    }
                    true
                }
            }
        }
    }

}