package com.example.dsc.UserData.page1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dsc.R
import com.example.dsc.UserData.UserEntity
import com.example.dsc.UserData.UserViewModel
import kotlinx.android.synthetic.main.fragment_page1.*

class page1 : Fragment() {

    lateinit var viewModel : UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel :: class.java)
        initListener()
    }

    fun initListener(){
        btn_save.setOnClickListener {
            val name = et_name.editableText.toString()
            val address = et_address.editableText.toString()
            val age = et_age.editableText.toString()

            if(name.isNotBlank() && address.isNotBlank() && age.isNotBlank()){
                val user = UserEntity(0, name, address, age)
                viewModel.insertData(user)
                Toast.makeText(requireContext(), "Upload Berhasil", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_page1_to_page2)
            } else {
                Toast.makeText(requireContext(), "Upload Gagal", Toast.LENGTH_SHORT).show()
            }

        }
    }
}