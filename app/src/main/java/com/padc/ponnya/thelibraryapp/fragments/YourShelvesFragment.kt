package com.padc.ponnya.thelibraryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.thelibraryapp.adapters.ShelvesAdapter
import com.padc.ponnya.thelibraryapp.databinding.FragmentYourShelvesBinding

class YourShelvesFragment : Fragment() {

    private lateinit var binding: FragmentYourShelvesBinding

    private lateinit var shelvesAdapter: ShelvesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYourShelvesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        shelvesAdapter = ShelvesAdapter()
        binding.rvShelves.adapter = shelvesAdapter
        binding.rvShelves.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}