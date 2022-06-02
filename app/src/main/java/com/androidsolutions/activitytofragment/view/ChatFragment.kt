package com.androidsolutions.activitytofragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.androidsolutions.activitytofragment.DataObj
import com.androidsolutions.activitytofragment.SharedViewModel
import com.androidsolutions.activitytofragment.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private val sharedViewModel by activityViewModels<SharedViewModel>()

    private val binding by lazy {
        FragmentChatBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
        binding.btnSend.setOnClickListener {
            sharedViewModel.setValue(DataObj(binding.etTxt.text.toString(),"From Chat"))
            binding.etTxt.setText("")
        }
    }

    private fun subscribeToObservers() {
        sharedViewModel.chatData.observe(viewLifecycleOwner){
            binding.tvTxt.text = it.txt
        }
    }

}