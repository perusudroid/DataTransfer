package com.androidsolutions.activitytofragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.androidsolutions.activitytofragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragAdapter by lazy { VPAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initVP()
        initClicks()
    }

    private fun initVP() {
        binding.viewPager.offscreenPageLimit = 2
        binding.viewPager.adapter = fragAdapter
    }

    private fun initClicks() {
        binding.btnSendToChat.setOnClickListener {
            binding.viewPager.currentItem = 0
            when(val frag = getCurrentFrag()){
               is ChatFragment -> frag.showText(binding.etTxt.text.toString())
            }
            binding.etTxt.setText("")
        }
        binding.btnSendToStatus.setOnClickListener {
            binding.viewPager.currentItem = 1
            when(val frag = getCurrentFrag()){
                is StatusFragment -> frag.showText(binding.etTxt.text.toString())
            }
            binding.etTxt.setText("")
        }
    }

    private fun getCurrentFrag() = supportFragmentManager.findFragmentByTag("f${binding.viewPager.currentItem}")

    fun setText(txt: String, label : String) {
        binding.tvTxt.text = txt
        binding.tvLabel.text = label
    }
}