package com.androidsolutions.activitytofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.androidsolutions.activitytofragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,IMainContractor{

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val fragment by lazy { MainFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        doLoadFragment()
        initClicks()
    }

    private fun initClicks() {
        binding.btnSend.setOnClickListener {
            fragment.showText(binding.etTxt.text.toString())
            binding.etTxt.setText("")
        }
    }

    private fun doLoadFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }

    override fun setText(txt: String) {
        binding.tvTxt.text = txt
    }
}