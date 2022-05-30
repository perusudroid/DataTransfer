package com.androidsolutions.activitytofragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidsolutions.activitytofragment.databinding.FragmentStatusBinding


class StatusFragment : Fragment() {

    private val binding by lazy { FragmentStatusBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSend.setOnClickListener {
            (requireActivity() as MainActivity).setText(binding.etTxt.text.toString(),"From Status")
            binding.etTxt.setText("")
        }
    }

    fun showText(msg: String) {
        binding.tvTxt.text = msg
    }



}