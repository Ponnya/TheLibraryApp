package com.padc.ponnya.thelibraryapp.activities


import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.View
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.padc.ponnya.thelibraryapp.R
import com.padc.ponnya.thelibraryapp.databinding.ActivityHomeBinding
import com.padc.ponnya.thelibraryapp.fragments.HomeFragment
import com.padc.ponnya.thelibraryapp.fragments.LibraryFragment
import com.padc.ponnya.thelibraryapp.mvp.presenters.HomePresenter
import com.padc.ponnya.thelibraryapp.mvp.views.HomeView
import com.padc.ponnya.thelibraryapp.utils.SCROLL_Y_POSITION

class HomeActivity : BaseActivity(), HomeView {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var mHomePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFragment()
        setUpListener()
        binding.appBar.elevation = 50f

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


        binding.scrollViewHome.setOnScrollChangeListener { _: View, _: Int, scrollY: Int, _: Int, _: Int ->
            if (scrollY == SCROLL_Y_POSITION) {
                binding.appBar.stateListAnimator =
                    AnimatorInflater.loadStateListAnimator(this, R.animator.appbar_elevation_off)
            } else {
                binding.appBar.stateListAnimator =
                    AnimatorInflater.loadStateListAnimator(this, R.animator.appbar_elevation_on)
            }
        }


    }

}