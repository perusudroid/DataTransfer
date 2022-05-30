package com.androidsolutions.activitytofragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidsolutions.activitytofragment.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private var contractor : IMainContractor?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSend.setOnClickListener {
            (requireActivity() as MainActivity).setText(binding.etTxt.text.toString())
            contractor?.setText(binding.etTxt.text.toString())
            binding.etTxt.setText("")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contractor = (context as MainActivity)
    }

    fun showText(msg: String) {
        binding.tvTxt.text = msg
    }



}