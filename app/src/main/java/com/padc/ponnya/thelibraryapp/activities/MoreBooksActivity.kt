package com.padc.ponnya.thelibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.padc.ponnya.thelibraryapp.adapters.MoreEbooksAdapter
import com.padc.ponnya.thelibraryapp.databinding.ActivityMoreBooksBinding

class MoreBooksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoreBooksBinding
    private lateinit var mMoreEbooksAdapter: MoreEbooksAdapter

    companion object {
        fun newIntent(context: Context) = Intent(context, MoreBooksActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mMoreEbooksAdapter = MoreEbooksAdapter()
        binding.rvMoreBooks.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        binding.rvMoreBooks.adapter = mMoreEbooksAdapter
    }
}