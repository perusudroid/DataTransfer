package com.androidsolutions.activitytofragment

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

    var fragList = arrayListOf(ChatFragment(), StatusFragment())

    override fun getItemCount() = fragList.size

    override fun createFragment(position: Int) = fragList[position]

}