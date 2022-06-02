package com.androidsolutions.activitytofragment.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.androidsolutions.activitytofragment.DataObj
import com.androidsolutions.activitytofragment.SharedViewModel
import com.androidsolutions.activitytofragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragAdapter by lazy { VPAdapter(this) }
    private val sharedViewModel by viewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initVP()
        subscribeToObservers()
        initClicks()
    }

    private fun subscribeToObservers() {
        sharedViewModel.data.observe(this){
            binding.tvTxt.text = it.txt
            binding.tvLabel.text = it.label
        }
    }

    private fun initVP() {
        binding.viewPager.offscreenPageLimit = 2
        binding.viewPager.adapter = fragAdapter
    }

    private fun initClicks() {
        binding.btnSendToChat.setOnClickListener {
            binding.viewPager.currentItem = 0
            when(getCurrentFrag()){
               is ChatFragment -> sharedViewModel.setChatValue(DataObj(binding.etTxt.text.toString()))
            }
            binding.etTxt.setText("")
        }
        binding.btnSendToStatus.setOnClickListener {
            binding.viewPager.currentItem = 1
            when(getCurrentFrag()){
                is StatusFragment -> sharedViewModel.setStatusValue(DataObj(binding.etTxt.text.toString()))
            }
            binding.etTxt.setText("")
        }
    }

    private fun getCurrentFrag() = supportFragmentManager.findFragmentByTag("f${binding.viewPager.currentItem}")

}