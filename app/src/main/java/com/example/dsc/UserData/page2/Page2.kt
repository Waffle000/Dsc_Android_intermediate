package com.example.dsc.UserData.page2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dsc.R
import com.example.dsc.UserData.UserViewModel
import kotlinx.android.synthetic.main.fragment_page2.*

class page2 : Fragment() {

    lateinit var viewModel : UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel :: class.java)
        setupRecycleView()
    }

    private fun setupRecycleView() {
        val pageAdapter = page2Adapter()
        with(rv_page2) {
            adapter = pageAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.getData.observe(viewLifecycleOwner, Observer {
            pageAdapter.setData(it)
        })
    }
}