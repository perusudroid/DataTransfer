package com.androidsolutions.activitytofragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.androidsolutions.activitytofragment.DataObj
import com.androidsolutions.activitytofragment.SharedViewModel
import com.androidsolutions.activitytofragment.databinding.FragmentStatusBinding


class StatusFragment : Fragment() {

    private val binding by lazy { FragmentStatusBinding.inflate(layoutInflater) }

    private val sharedViewModel by activityViewModels<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
        binding.btnSend.setOnClickListener {
            sharedViewModel.setValue(DataObj(binding.etTxt.text.toString(),"From Status"))
            binding.etTxt.setText("")
        }
    }

    private fun subscribeToObservers() {
        sharedViewModel.statusData.observe(viewLifecycleOwner){
            binding.tvTxt.text = it.txt
        }
    }



}