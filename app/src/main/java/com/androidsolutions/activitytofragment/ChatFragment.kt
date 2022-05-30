package com.androidsolutions.activitytofragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidsolutions.activitytofragment.databinding.FragmentChatBinding
import com.androidsolutions.activitytofragment.databinding.FragmentStatusBinding

class ChatFragment : Fragment() {

    private val binding by lazy {
        FragmentChatBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSend.setOnClickListener {
            (requireActivity() as MainActivity).setText(binding.etTxt.text.toString(),"From Chat")
            binding.etTxt.setText("")
        }
    }

    fun showText(msg: String) {
        binding.tvTxt.text = msg
    }

}